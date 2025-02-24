package com.example.calculatorserver;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class CalculationService extends Service {

    private static final String TAG = "CalculationService"; // For logging

    public static final String ACTION_CALCULATE = "com.example.calculatorserver.CALCULATE";
    public static final String ACTION_RESULT = "com.example.calculatorserver.RESULT";

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "Service created");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand called");

        if (intent != null) {
            handleIntent(intent);
        }

        return START_STICKY;
    }

    private void handleIntent(Intent intent) {
        final String action = intent.getAction();
        if (ACTION_CALCULATE.equals(action)) {
            final double num1 = intent.getDoubleExtra("number1", 0);
            final double num2 = intent.getDoubleExtra("number2", 0);
            final String operation = intent.getStringExtra("operation");
            // Create a new thread for the calculation
            new Thread(() -> {
                double result = handleActionCalculate(num1, num2, operation); // Your calculation logic

                Intent resultIntent = new Intent(ACTION_RESULT);
                resultIntent.putExtra("result", result);
                sendBroadcast(resultIntent); // Send the broadcast

                Log.d(TAG, "Calculation: " + num1 + " " + operation + " " + num2 + " = " + result);
            }).start();
        }
    }

    private double handleActionCalculate(double number1, double number2, String operation) {
        switch (operation) {
            case "add":
                return number1 + number2;
            case "subtract":
                return number1 - number2;
            case "multiply":
                return number1 * number2;
            case "divide":
                return number1 / number2;
            default:
                return 0;
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "Service destroyed");
    }
}