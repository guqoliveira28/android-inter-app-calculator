package com.example.calculatorserver.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class StartReceiver extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {
        Intent startIntent = context
                .getPackageManager()
                .getLaunchIntentForPackage(context.getPackageName());

        context.startActivity(startIntent);
    }
}
