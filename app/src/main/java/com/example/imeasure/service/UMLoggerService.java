package com.example.imeasure.service;

import android.Manifest;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.telephony.PhoneStateListener;
import android.telephony.ServiceState;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;

import com.example.imeasure.R;
import com.example.imeasure.ui.UMLogger;
import com.example.imeasure.util.BatteryStats;
import com.example.imeasure.util.SystemInfo;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class UMLoggerService extends Service {
    private static final String TAG = "UMLoggerService";

    private static final int NOTIFICATION_ID = 1;
    private static final int NOTIFICATION_ID_LETTER = 2;

    private Thread estimatorThread;
    private PowerEstimator powerEstimator;

    private Notification notification;

    private NotificationManager notificationManager;
    private TelephonyManager phoneManager;

    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    @Override
    public void onCreate() {
        powerEstimator = new PowerEstimator(this);

        /* Register to receive phone state messages. */
        phoneManager = (TelephonyManager) this.getSystemService(TELEPHONY_SERVICE);
        phoneManager.listen(phoneListener, PhoneStateListener.LISTEN_CALL_STATE |
                PhoneStateListener.LISTEN_DATA_CONNECTION_STATE |
                PhoneStateListener.LISTEN_SERVICE_STATE |
                PhoneStateListener.LISTEN_SIGNAL_STRENGTH);

        /* Register to receive airplane mode and battery low messages. */
        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        filter.addAction(Intent.ACTION_BATTERY_LOW);
        filter.addAction(Intent.ACTION_BATTERY_CHANGED);
        filter.addAction(Intent.ACTION_PACKAGE_REMOVED);
        filter.addAction(Intent.ACTION_PACKAGE_REPLACED);
        registerReceiver(broadcastIntentReceiver, filter);

        notificationManager = (NotificationManager) getSystemService(
                NOTIFICATION_SERVICE);
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);

        if (intent.getBooleanExtra("stop", false)) {
            stopSelf();
            return;
        } else if (estimatorThread != null) {
            return;
        }
        showNotification();
        estimatorThread = new Thread(powerEstimator);
        estimatorThread.start();
    }

    @Override
    public void onDestroy() {
//android.os.Debug.stopMethodTracing();
        if (estimatorThread != null) {
            estimatorThread.interrupt();
            while (estimatorThread.isAlive()) {
                try {
                    estimatorThread.join();
                } catch (InterruptedException e) {
                }
            }
        }
        unregisterReceiver(broadcastIntentReceiver);

        /* See comments in showNotification() for why we are using reflection here.
         */
        boolean foregroundSet = false;
        try {
            Method stopForeground = getClass().getMethod("stopForeground",
                    boolean.class);
            stopForeground.invoke(this, true);
            foregroundSet = true;
        } catch (InvocationTargetException e) {
        } catch (IllegalAccessException e) {
        } catch (NoSuchMethodException e) {
        }
        if (!foregroundSet) {
            stopForeground(true);
            notificationManager.cancel(NOTIFICATION_ID);
        }

        super.onDestroy();
    }

    ;

    /** This function is to construct the real-time updating notification*/


    public void showNotification() {
        int icon = R.drawable.level;

        CharSequence contentTitle = "IMeasure";  // expanded message title
        CharSequence contentText = "Message";      // expanded message text
        Intent notificationIntent = new Intent(this, UMLogger.class);
        notificationIntent.putExtra("isFromIcon", true);
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0,
                notificationIntent,
                PendingIntent.FLAG_UPDATE_CURRENT);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel chan = new NotificationChannel(contentTitle.toString(),
                    contentText.toString(), NotificationManager.IMPORTANCE_NONE);
            chan.setLightColor(Color.BLUE);
            chan.setLockscreenVisibility(Notification.VISIBILITY_PRIVATE);
            NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

            manager.createNotificationChannel(chan);

            NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this, contentTitle.toString());
            notification = notificationBuilder.setOngoing(true)
                    .setSmallIcon(R.drawable.level)
                    .setContentTitle("App is running in background")
                    .setPriority(NotificationManager.IMPORTANCE_MIN)
                    .setCategory(Notification.CATEGORY_SERVICE)
                    .build();
            startForeground(NOTIFICATION_ID, notification);
        } else {
            NotificationCompat.Builder mBuilder =
                    new NotificationCompat.Builder(this, contentTitle.toString())
                            .setContentIntent(contentIntent)
                            .setSmallIcon(icon)
                            .setWhen(System.currentTimeMillis())
                            .setContentTitle(contentTitle)
                            .setContentText(contentText);
            notification = mBuilder.build();
            startForeground(NOTIFICATION_ID, notification);
        }
    }

    /* This function is to update the notification in real time.  This function
     * is apparently fairly expensive cpu wise.  Updating once a second caused a
     * 8% cpu utilization penalty.
     */
    public void updateNotification(int level, double totalPower) {
        notification.icon = R.drawable.level;
        notification.iconLevel = level;

        // If we know how much charge the battery has left we'll override the
        // normal icon with one that indicates how much time the user can expect
        // left.
        BatteryStats bst = BatteryStats.getInstance();
        if (bst.hasCharge() && bst.hasVoltage()) {
            double charge = bst.getCharge();
            double volt = bst.getVoltage();
            if (charge > 0 && volt > 0) {
                notification.icon = R.drawable.time;

                double minutes = charge * volt / (totalPower / 1000) / 60;
                if (minutes < 55) {
                    notification.iconLevel = 1 +
                            (int) Math.max(0, Math.round(minutes / 10.0) - 1);
                } else {
                    notification.iconLevel = (int) Math.min(13,
                            6 + Math.max(0, Math.round(minutes / 60.0) - 1));
                }
            }
        }

        CharSequence contentTitle = "IMeasure";
        CharSequence contentText = "Total Power: " + (int) Math.round(totalPower) +
                " mW";

        /* When the user selects the notification the tab view for global power
         * usage will appear.
         */
        Intent notificationIntent = new Intent(this, UMLogger.class);
        notificationIntent.putExtra("isFromIcon", true);
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0,
                notificationIntent, 0);

        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(this, contentTitle.toString())
                        .setContentIntent(contentIntent)
                        .setSmallIcon(notification.icon)
                        .setWhen(System.currentTimeMillis())
                        .setContentTitle(contentTitle)
                        .setContentText(contentText);
        notification = mBuilder.build();
        notificationManager.notify(NOTIFICATION_ID, notification);
    }

    private final ICounterService.Stub binder =
            new ICounterService.Stub() {
                public String[] getComponents() {
                    return powerEstimator.getComponents();
                }

                public int[] getComponentsMaxPower() {
                    return powerEstimator.getComponentsMaxPower();
                }

                public int getNoUidMask() {
                    return powerEstimator.getNoUidMask();
                }

                public int[] getComponentHistory(int count, int componentId, int uid) {
                    return powerEstimator.getComponentHistory(count, componentId, uid, -1);
                }

                public long[] getTotals(int uid, int windowType) {
                    return powerEstimator.getTotals(uid, windowType);
                }

                public long getRuntime(int uid, int windowType) {
                    return powerEstimator.getRuntime(uid, windowType);
                }

                public long[] getMeans(int uid, int windowType) {
                    return powerEstimator.getMeans(uid, windowType);
                }

                public byte[] getUidInfo(int windowType, int ignoreMask) {
                    UidInfo[] infos = powerEstimator.getUidInfo(windowType, ignoreMask);
                    ByteArrayOutputStream output = new ByteArrayOutputStream();
                    try {
                        new ObjectOutputStream(output).writeObject(infos);
                    } catch (IOException e) {
                        return null;
                    }
                    for (UidInfo info : infos) {
                        info.recycle();
                    }
                    return output.toByteArray();
                }

                public long getUidExtra(String name, int uid) {
                    return powerEstimator.getUidExtra(name, uid);
                }
            };


    BroadcastReceiver broadcastIntentReceiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals(Intent.ACTION_AIRPLANE_MODE_CHANGED)) {
                Bundle extra = intent.getExtras();
                try {
                    if ((Boolean) extra.get("state")) {
                        powerEstimator.writeToLog("airplane-mode on\n");
                    } else {
                        powerEstimator.writeToLog("airplane-mode off\n");
                    }
                } catch (ClassCastException e) {
                    // Some people apparently are having this problem.  I'm not really
                    // sure why this should happen.
                    Log.w(TAG, "Couldn't determine airplane mode state");
                }
            } else if (intent.getAction().equals(Intent.ACTION_BATTERY_LOW)) {
                powerEstimator.writeToLog("battery low\n");
            } else if (intent.getAction().equals(Intent.ACTION_BATTERY_CHANGED)) {
                powerEstimator.writeToLog("battery-change " +
                        intent.getIntExtra("plugged", -1) + " " +
                        intent.getIntExtra("level", -1) + "/" +
                        intent.getIntExtra("scale", -1) + " " +
                        intent.getIntExtra("voltage", -1) +
                        intent.getIntExtra("temperature", -1) + "\n");
                powerEstimator.plug(
                        intent.getIntExtra("plugged", -1) != 0);
            } else if (intent.getAction().equals(Intent.ACTION_PACKAGE_REMOVED) ||
                    intent.getAction().equals(Intent.ACTION_PACKAGE_REPLACED)) {
                // A package has either been removed or its metadata has changed and we
                // need to clear the cache of metadata for that app.
                SystemInfo.getInstance().voidUidCache(
                        intent.getIntExtra(Intent.EXTRA_UID, -1));
            }
        }

        ;
    };

    PhoneStateListener phoneListener = new PhoneStateListener() {
        public void onServiceStateChanged(ServiceState serviceState) {
            switch (serviceState.getState()) {
                case ServiceState.STATE_EMERGENCY_ONLY:
                    powerEstimator.writeToLog("phone-service emergency-only\n");
                    break;
                case ServiceState.STATE_IN_SERVICE:
                    powerEstimator.writeToLog("phone-service in-service\n");
                    if (ActivityCompat.checkSelfPermission(UMLoggerService.this, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
                        Toast.makeText(UMLoggerService.this, "Please allow telephone permission", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    switch (phoneManager.getNetworkType()) {
                        case (TelephonyManager.NETWORK_TYPE_EDGE):
                            powerEstimator.writeToLog("phone-network edge\n");
                            break;
                        case (TelephonyManager.NETWORK_TYPE_GPRS):
                            powerEstimator.writeToLog("phone-network GPRS\n");
                            break;
                        case 8:
                            powerEstimator.writeToLog("phone-network HSDPA\n");
                            break;
                        case (TelephonyManager.NETWORK_TYPE_UMTS):
                            powerEstimator.writeToLog("phone-network UMTS\n");
                            break;
                        default:
                            powerEstimator.writeToLog("phone-network " +
                                    phoneManager.getNetworkType() + "\n");
                    }
                    break;
                case ServiceState.STATE_OUT_OF_SERVICE:
                    powerEstimator.writeToLog("phone-service out-of-service\n");
                    break;
                case ServiceState.STATE_POWER_OFF:
                    powerEstimator.writeToLog("phone-service power-off\n");
                    break;
            }
        }

        public void onCallStateChanged(int state, String incomingNumber) {
            switch(state) {
                case TelephonyManager.CALL_STATE_IDLE:
                    powerEstimator.writeToLog("phone-call idle\n");
                    break;
                case TelephonyManager.CALL_STATE_OFFHOOK:
                    powerEstimator.writeToLog("phone-call off-hook\n");
                    break;
                case TelephonyManager.CALL_STATE_RINGING:
                    powerEstimator.writeToLog("phone-call ringing\n");
                    break;
            }
        }

        public void onDataConnectionStateChanged(int state) {
            switch(state) {
                case TelephonyManager.DATA_DISCONNECTED:
                    powerEstimator.writeToLog("data disconnected\n");
                    break;
                case TelephonyManager.DATA_CONNECTING:
                    powerEstimator.writeToLog("data connecting\n");
                    break;
                case TelephonyManager.DATA_CONNECTED:
                    powerEstimator.writeToLog("data connected\n");
                    break;
                case TelephonyManager.DATA_SUSPENDED:
                    powerEstimator.writeToLog("data suspended\n");
                    break;
            }
        }

        public void onSignalStrengthChanged(int asu) {
            powerEstimator.writeToLog("signal " + asu + "\n");
        }
    };
}
