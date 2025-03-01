package com.example.calculatorserver.service;

import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.util.Log;

import androidx.core.content.ContextCompat;

import com.example.calculatorserver.notification.NotificationsHelper;
import com.example.calculatorserver.receiver.CalculationReceiver;

public class CalculationService extends Service {

    private static final String TAG = "CalculationService";

    private static final String ACTION_CALCULATE = "com.example.calculatorserver.action.CALCULATE";

    private CalculationReceiver calculationReceiver;

    @Override
    public void onCreate() {
        super.onCreate();

        calculationReceiver = new CalculationReceiver();

        ContextCompat.registerReceiver(this, calculationReceiver, new IntentFilter(ACTION_CALCULATE), ContextCompat.RECEIVER_EXPORTED);

        Log.d(TAG, "Service created");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand called");

        NotificationsHelper.createNotificationChannel(this);

        this.startForeground(1, NotificationsHelper.buildNotification(this));

        return Service.START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(calculationReceiver);
        stopForeground(true);
        Log.d(TAG, "Service destroyed");
    }
}