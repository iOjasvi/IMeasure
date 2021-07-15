package com.example.imeasure.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.example.imeasure.service.UMLoggerService;

public class StartupReceiver extends BroadcastReceiver {
  @Override
  public void onReceive(Context context, Intent intent) {
    SharedPreferences prefs =
        PreferenceManager.getDefaultSharedPreferences(context);
    if(prefs.getBoolean("runOnStartup", true)) {
      Intent serviceIntent = new Intent(context, UMLoggerService.class);
      context.startService(serviceIntent);
    }
  }
}

