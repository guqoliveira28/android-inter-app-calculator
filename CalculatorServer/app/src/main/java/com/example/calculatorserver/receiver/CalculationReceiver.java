package com.example.calculatorserver.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.example.calculatorserver.operations.OperationFactory;
import com.example.calculatorserver.operations.OperationInterface;

public class CalculationReceiver extends BroadcastReceiver {
    private static final String TAG = "CalculationService";

    private static final String ACTION_CALCULATE = "com.example.calculatorserver.action.CALCULATE";
    private static final String ACTION_RESULT = "com.example.calculatorserver.action.RESULT";
    private static final String ACTION_HISTORY= "com.example.calculatorserver.action.HISTORY";

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "Received something");

        if (intent != null) {
            String action = intent.getAction();
            if (ACTION_CALCULATE.equals(action)) {
                String errorMessage = null;
                double result = 0;
                double num1 = intent.getDoubleExtra("NUMBER1", 0);
                double num2 = intent.getDoubleExtra("NUMBER2", 0);
                String operation = intent.getStringExtra("OPERATION");

                Log.d(TAG, "Received calculation request in service: " + num1 + " " + operation + " " + num2);

                try {
                    if (operation == null) {
                        throw new IllegalArgumentException("Operation cannot be null");
                    }

                    OperationInterface currentOperation = OperationFactory.getOperation(operation);

                    result = currentOperation.performOperation(num1, num2);

                } catch (IllegalArgumentException | ArithmeticException e) {
                    Log.e(TAG, "Calculation error: " + e.getMessage());
                    errorMessage = e.getMessage();
                }

                Intent resultIntent = new Intent(ACTION_RESULT);
                intent.setPackage(intent.getStringExtra("PACKAGE"));
                resultIntent.putExtra("RESULT", result);
                resultIntent.putExtra("ERROR", errorMessage);
                context.sendBroadcast(resultIntent);

                Log.d(TAG, "Calculation result in service: " + result);
            }
        }
    }
}
