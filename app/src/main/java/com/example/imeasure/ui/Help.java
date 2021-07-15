package com.example.imeasure.ui;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.example.imeasure.R;

/**This function implements the UI for help view*/
public class Help extends Activity {
  private static final String powerTutorUrl = "http://imeasure.org";

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState); 
    setContentView(R.layout.help);
    TextView s2 = (TextView)this.findViewById(R.id.S2);

    s2.setOnClickListener(new TextView.OnClickListener() {
      public void onClick(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW,
                                     Uri.parse(powerTutorUrl));
        startActivity(myIntent);
      }
    });
  }
}
