package com.example.calculatorclient.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.TextView;

public class CalculationResultReceiver extends BroadcastReceiver {

    private TextView resultTextView;

    public CalculationResultReceiver(TextView resultTextView) {
        this.resultTextView = resultTextView;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        if (CalculationUtils.ACTION_RESULT.equals(intent.getAction())) { // Use your action string
            double result = intent.getDoubleExtra("result", 0);
            resultTextView.setText(String.valueOf(result));
        }
    }
}
