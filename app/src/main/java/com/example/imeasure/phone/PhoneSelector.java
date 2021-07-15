package com.example.imeasure.phone;

import android.content.Context;
import android.os.Build;
import android.util.Log;

import com.example.imeasure.components.Audio;
import com.example.imeasure.components.CPU;
import com.example.imeasure.components.GPS;
import com.example.imeasure.components.LCD;
import com.example.imeasure.components.OLED;
import com.example.imeasure.components.PowerComponent;
import com.example.imeasure.components.Sensors;
import com.example.imeasure.components.Threeg;
import com.example.imeasure.components.Wifi;
import com.example.imeasure.service.PowerData;
import com.example.imeasure.util.NotificationService;
import com.example.imeasure.util.SystemInfo;

import java.util.List;


public class PhoneSelector {
  private static final String TAG = "PhoneSelector";

  public static final int PHONE_UNKNOWN = 0;
  public static final int PHONE_DREAM = 1; /* G1 */
  public static final int PHONE_SAPPHIRE = 2; /* G2 */
  public static final int PHONE_PASSION = 3; /* Nexus One */

  /* A hard-coded list of phones that have OLED screens. */
  public static final String[] OLED_PHONES = {
    "bravo",
    "passion",
    "GT-I9000",
    "inc",
    "legend",
    "GT-I7500",
    "SPH-M900",
    "SGH-I897",
    "SGH-T959",
    "desirec",
  };


  /* This class is not supposed to be instantiated.  Just use the static
   * members.
   */
  private PhoneSelector() {}

  public static boolean phoneSupported() {
    return getPhoneType() != PHONE_UNKNOWN;
  }

  public static boolean hasOled() {
    for(int i = 0; i < OLED_PHONES.length; i++) {
      if(Build.DEVICE.equals(OLED_PHONES[i])) {
        return true;
      }
    }
    return false;
  }

  public static int getPhoneType() {
    if(Build.DEVICE.startsWith("dream")) return PHONE_DREAM;
    if(Build.DEVICE.startsWith("sapphire")) return PHONE_SAPPHIRE;
    if(Build.DEVICE.startsWith("passion")) return PHONE_PASSION;
    return PHONE_UNKNOWN;
  }

  public static PhoneConstants getConstants(Context context) {
    switch(getPhoneType()) {
      case PHONE_DREAM:
        return new DreamConstants(context);
      case PHONE_SAPPHIRE:
        return new SapphireConstants(context);
      case PHONE_PASSION:
        return new PassionConstants(context);
      default:
        boolean oled = hasOled();
        Log.w(TAG, "Phone type not recognized (" + Build.DEVICE + "), using " +
              (oled ? "Passion" : "Dream") + " constants");
        return oled ? new PassionConstants(context) :
                      new DreamConstants(context);
    }
  }

  public static PhonePowerCalculator getCalculator(Context context) {
    switch(getPhoneType()) {
      case PHONE_DREAM:
        return new DreamPowerCalculator(context);
      case PHONE_SAPPHIRE:
        return new SapphirePowerCalculator(context);
      case PHONE_PASSION:
        return new PassionPowerCalculator(context);
      default:
        boolean oled = hasOled();
        Log.w(TAG, "Phone type not recognized (" + Build.DEVICE + "), using " +
              (oled ? "Passion" : "Dream") + " calculator");
        return oled ? new PassionPowerCalculator(context) :
                      new DreamPowerCalculator(context);
    }
  }

  public static void generateComponents(Context context,
                                        List<PowerComponent> components,
                                        List<PowerFunction> functions) {
    final PhoneConstants constants = getConstants(context);
    final PhonePowerCalculator calculator = getCalculator(context);

    //TODO: What about bluetooth?
    //TODO: LED light on the Nexus

    /* Add display component. */
    if(hasOled()) {
      components.add(new OLED(context, constants));
      functions.add(new PowerFunction() {
        public double calculate(PowerData data) {
          return calculator.getOledPower((OLED.OledData)data);
        }});
    } else {
      components.add(new LCD(context));
      functions.add(new PowerFunction() {
        public double calculate(PowerData data) {
          return calculator.getLcdPower((LCD.LcdData)data);
        }});
    }

    /* Add CPU component. */
    components.add(new CPU(constants));
    functions.add(new PowerFunction() {
      public double calculate(PowerData data) {
        return calculator.getCpuPower((CPU.CpuData)data);
      }});

    /* Add Wifi component. */
    String wifiInterface =
        SystemInfo.getInstance().getProperty("wifi.interface");
    if(wifiInterface != null && wifiInterface.length() != 0) {
      components.add(new Wifi(context, constants));
      functions.add(new PowerFunction() {
        public double calculate(PowerData data) {
          return calculator.getWifiPower((Wifi.WifiData)data);
        }});
    }

    /* Add 3G component. */
    if(constants.threegInterface().length() != 0) {
      components.add(new Threeg(context, constants));
      functions.add(new PowerFunction() {
        public double calculate(PowerData data) {
          return calculator.getThreeGPower((Threeg.ThreegData)data);
        }});
    }

    /* Add GPS component. */
    components.add(new GPS(context, constants));
    functions.add(new PowerFunction() {
      public double calculate(PowerData data) {
        return calculator.getGpsPower((GPS.GpsData)data);
      }});

    /* Add Audio component. */
    components.add(new Audio(context));
    functions.add(new PowerFunction() {
      public double calculate(PowerData data) {
        return calculator.getAudioPower((Audio.AudioData)data);
      }});

    /* Add Sensors component if avaialble. */
    if(NotificationService.available()) {
      components.add(new Sensors(context));
      functions.add(new PowerFunction() {
        public double calculate(PowerData data) {
          return calculator.getSensorPower((Sensors.SensorData)data);
        }});
    }
  }
}
