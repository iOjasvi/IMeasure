package com.example.imeasure.widget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.RemoteViews;

import com.example.imeasure.R;
import com.example.imeasure.service.PowerEstimator;
import com.example.imeasure.ui.UMLogger;
import com.example.imeasure.util.HexEncode;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;


public class PowerWidget extends AppWidgetProvider {
    private static final String TAG = "PowerWidget";

    private static final int[] text_ids = {
            R.id.text_minute,
            R.id.text_hour,
            R.id.text_day,
    };

    private static long sumArray(long[] A) {
        long ret = 0;
        for(long x : A) {
            ret += x;
        }
        return ret;
    }

    // Called once initially.
    public void onUpdate(Context context, AppWidgetManager appWidgetManager,
                         int[] appWidgetIds) {
        updateWidgetDone(context);
    }

    public void onDeleted(Context context, int[] appWidgetIds) {
        SharedPreferences.Editor edit =
                PreferenceManager.getDefaultSharedPreferences(context).edit();
        for(int id : appWidgetIds) {
            edit.remove("widget_" + id);
        }
        edit.commit();
    }

    public static void updateWidgetDone(Context context) {
        AppWidgetManager manager = AppWidgetManager.getInstance(context);
        ComponentName comp = new ComponentName(context, PowerWidget.class);
        RemoteViews views = new RemoteViews(context.getPackageName(),
                R.layout.widget_layout);

        Intent notificationIntent = new Intent(context, UMLogger.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0,
                notificationIntent,
                PendingIntent.FLAG_UPDATE_CURRENT);

        views.setOnClickPendingIntent(R.id.power_button, pendingIntent);
        views.setInt(R.id.power_button, "setImageResource",
                R.drawable.power_off);
        for(int i = 0; i < text_ids.length; i++) {
            views.setTextViewText(text_ids[i], "N/A");
        }
        manager.updateAppWidget(comp, views);
    }

    // Called by the UMLogger Service every so often.
    public static void updateWidget(Context context, PowerEstimator p) {
        AppWidgetManager manager = AppWidgetManager.getInstance(context);
        ComponentName comp = new ComponentName(context, PowerWidget.class);

        for(int id : manager.getAppWidgetIds(comp)) {
            RemoteViews views = new RemoteViews(context.getPackageName(),
                    R.layout.widget_layout);

            Intent notificationIntent = new Intent(context, UMLogger.class);
            notificationIntent.putExtra("isFromIcon", true);
            PendingIntent pendingIntent = PendingIntent.getActivity(context, 0,
                    notificationIntent,
                    PendingIntent.FLAG_UPDATE_CURRENT);

            views.setOnClickPendingIntent(R.id.power_button, pendingIntent);
            views.setInt(R.id.power_button, "setImageResource",
                    R.drawable.power_on);

            boolean ok = false;
            try {
                SharedPreferences prefs =
                        PreferenceManager.getDefaultSharedPreferences(context);
                String key = "widget_" + id;
                String val = prefs.getString(key, null);
                if(val != null) {
                    ObjectInputStream objin = new ObjectInputStream(
                            new ByteArrayInputStream(HexEncode.decode(val)));
                    for(int i = 0; i < text_ids.length; i++) {
                        DataSource dataSource = (DataSource)objin.readObject();
                        views.setTextViewText(text_ids[i], dataSource.getValue(p));
                    }
                    ok = true;
                } else {
                    Log.w(TAG, "Could not find widget data source preference");
                }
            } catch(IOException e) {
                Log.w(TAG, "Failed to extract widget data sources");
            } catch(ClassCastException e) {
                Log.w(TAG, "Failed to extract widget data sources");
            } catch(ClassNotFoundException e) {
                Log.w(TAG, "Failed to extract widget data sources");
            }
            if(!ok) {
                for(int i =0; i < text_ids.length; i++) {
                    views.setTextViewText(text_ids[i], "N/A");
                }
            }
            for(int i =0; i < text_ids.length; i++) {
                views.setTextColor(text_ids[i], 0xFFFFFFFF);
            }

            manager.updateAppWidget(id, views);
        }
    }
}
