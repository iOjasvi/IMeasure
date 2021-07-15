package com.example.imeasure.phone;


import com.example.imeasure.components.Audio;
import com.example.imeasure.components.CPU;
import com.example.imeasure.components.GPS;
import com.example.imeasure.components.LCD;
import com.example.imeasure.components.OLED;
import com.example.imeasure.components.Sensors;
import com.example.imeasure.components.Threeg;
import com.example.imeasure.components.Wifi;

public interface PhonePowerCalculator {
  public double getLcdPower(LCD.LcdData data);

  public double getOledPower(OLED.OledData data);

  public double getCpuPower(CPU.CpuData data);

  public double getAudioPower(Audio.AudioData data);

  public double getGpsPower(GPS.GpsData data);

  public double getWifiPower(Wifi.WifiData data);

  public double getThreeGPower(Threeg.ThreegData data);

  public double getSensorPower(Sensors.SensorData data);
}

