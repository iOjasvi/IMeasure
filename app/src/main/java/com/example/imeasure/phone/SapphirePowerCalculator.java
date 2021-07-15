package com.example.imeasure.phone;

import android.content.Context;

public class SapphirePowerCalculator extends DreamPowerCalculator {
  public SapphirePowerCalculator(Context context) {
    super(new SapphireConstants(context));
  }

  public SapphirePowerCalculator(PhoneConstants coeffs) {
    super(coeffs);
  }
}
