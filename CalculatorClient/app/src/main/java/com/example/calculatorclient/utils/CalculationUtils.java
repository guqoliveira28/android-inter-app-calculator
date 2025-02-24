package com.example.calculatorclient.utils;

import android.content.Context;
import android.content.Intent;

public class CalculationUtils {
    public static final String EXTRA_NUM1 = "number1";
    public static final String EXTRA_NUM2 = "number2";
    public static final String EXTRA_OPERATION = "operation";
    public static final String ACTION_CALCULATE = "com.example.calculatorserver.CALCULATE";
    public static final String ACTION_RESULT = "com.example.calculatorserver.RESULT";

    public static void startCalculationService(Context context, double number1, double number2, String operation) {
        Intent intent = new Intent();
        intent.setAction(ACTION_CALCULATE);
        intent.putExtra(EXTRA_NUM1, number1);
        intent.putExtra(EXTRA_NUM2, number2);
        intent.putExtra(EXTRA_OPERATION, operation);
        context.startService(intent);
    }
}
