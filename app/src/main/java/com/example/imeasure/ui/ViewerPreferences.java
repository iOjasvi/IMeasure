package com.example.imeasure.ui;

import android.os.Bundle;
import android.preference.PreferenceActivity;
import com.example.imeasure.R;

public class ViewerPreferences extends PreferenceActivity {
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    addPreferencesFromResource(R.xml.viewer_preferences);
  }
}
