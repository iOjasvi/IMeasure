package com.example.imeasure.ui;

import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TabHost;
import com.example.imeasure.R;

public class PowerTabs extends TabActivity {
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.power_tabs);

    Resources res = getResources();
    TabHost tabHost = getTabHost();
    TabHost.TabSpec spec;

    // TODO: We could put in some icons on each of these two tabs.  Not sure if
    // we care enough or if it would look much better.
    Intent intent = new Intent(this, PowerViewer.class);
    intent.putExtras(getIntent());
    spec = tabHost.newTabSpec("Charts").setIndicator("Chart View")
                  .setContent(intent);
    tabHost.addTab(spec);

    // Do the same for the other tabs
    intent = new Intent(this, PowerPie.class);
    intent.putExtras(getIntent());
    spec = tabHost.newTabSpec("Pie").setIndicator("Pie View")
                  .setContent(intent);
    tabHost.addTab(spec);

    intent = new Intent(this, MiscView.class);
    intent.putExtras(getIntent());
    spec = tabHost.newTabSpec("Stat").setIndicator("Stat View")
                  .setContent(intent);
    tabHost.addTab(spec);

    // Show the PowerViewer activity by default.
    tabHost.setCurrentTab(0);
  }
}
