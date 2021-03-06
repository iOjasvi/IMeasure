package com.example.imeasure.widget;

import android.app.Activity;
import android.appwidget.AppWidgetManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.imeasure.R;
import com.example.imeasure.util.HexEncode;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;


public class Configure extends Activity {
    private static final String TAG = "Configure";

    private int widgetId = AppWidgetManager.INVALID_APPWIDGET_ID;

    private ArrayAdapter adapter;
    private DataSource[] dataSource;
    private WidgetItem[] items;

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setResult(RESULT_CANCELED);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        if(extras != null) {
            widgetId = extras.getInt(AppWidgetManager.EXTRA_APPWIDGET_ID,
                    AppWidgetManager.INVALID_APPWIDGET_ID);
        }
        if(widgetId == AppWidgetManager.INVALID_APPWIDGET_ID) {
            finish();
        }

        setContentView(R.layout.widget_configure);
        findViewById(R.id.save_button).setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        String val = "";
                        try {
                            ByteArrayOutputStream ba = new ByteArrayOutputStream();
                            ObjectOutputStream objout = new ObjectOutputStream(ba);
                            for(int i = 0; i < dataSource.length; i++) {
                                objout.writeObject(dataSource[i]);
                            }
                            objout.close();
                            val = HexEncode.encode(ba.toByteArray());
                        } catch(IOException e) {
                            Log.w(TAG, "Failed to write data sources to string");
                            finish();
                        }
                        String key = "widget_" + widgetId;

                        SharedPreferences prefs =
                                PreferenceManager.getDefaultSharedPreferences(Configure.this);
                        prefs.edit().putString(key, val).commit();

                        Intent resultValue = new Intent();
                        resultValue.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, widgetId);
                        setResult(RESULT_OK, resultValue);
                        finish();
                    }
                });
        findViewById(R.id.cancel_button).setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        finish();
                    }
                });

        final ListView listView = (ListView)findViewById(R.id.list);
        adapter = new ArrayAdapter(this, 0) {
            public View getView(int position, View convertView, ViewGroup parent) {
                View itemView = getLayoutInflater()
                        .inflate(R.layout.widget_item_layout, listView, false);
                TextView title = (TextView)itemView.findViewById(R.id.title);
                TextView summary = (TextView)itemView.findViewById(R.id.summary);
                WidgetItem item = (WidgetItem)getItem(position);
                item.setupView(title, summary);
                return itemView;
            }
        };

        dataSource = DataSource.getDefaults();
        items = new WidgetItem[3];

        for(int i = 0; i < 3; i++) {
            items[i] = new WidgetItem(i);
            adapter.add(items[i]);
        }
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView parent, View view,
                                    int position, long id) {
                items[position].onClick();
            }
        });
    }

    @Override
    protected void onActivityResult(int reqCode, int resCode, Intent data) {
        if(resCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            DataSource dataSrc = (DataSource)extras.getSerializable("data_source");
            dataSource[reqCode] = dataSrc;
            adapter.notifyDataSetChanged();
        }
    }

    private class WidgetItem {
        private int columnId;

        public WidgetItem(int columnId) {
            this.columnId = columnId;
        }

        public void setupView(TextView title, TextView summary) {
            title.setText("Column " + (columnId + 1) + " - " +
                    dataSource[columnId].getTitle());
            summary.setText(dataSource[columnId].getDescription());
        }

        public void onClick() {
            Intent startIntent = new Intent(Configure.this,
                    DataSourceConfigure.class);
            startActivityForResult(startIntent, columnId);
        }
    }
}
