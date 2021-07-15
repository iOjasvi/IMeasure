package com.example.imeasure.phone;

import android.content.Context;

import com.example.imeasure.components.OLED;

public class PassionPowerCalculator extends DreamPowerCalculator {
    public PassionPowerCalculator(Context context) {
        super(new PassionConstants(context));
    }

    public PassionPowerCalculator(PhoneConstants coeffs) {
        super(coeffs);
    }

    @Override
    public double getOledPower(OLED.OledData data) {
        if(!data.screenOn) {
            return 0;
        }
        if(data.pixPower == -1) {
            /* No pixel power available :(. */
            return coeffs.oledBasePower() + coeffs.lcdBrightness() * data.brightness;
        } else {
            return coeffs.oledBasePower() + data.pixPower * data.brightness;
        }
    }
}
