package com.example.calculatorclient.utils;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class CalculationUtils {
    private static final String EXTRA_NUM1 = "NUMBER1";
    private static final String EXTRA_NUM2 = "NUMBER2";
    private static final String EXTRA_OPERATION = "OPERATION";
    private static final String EXTRA_PACKAGE = "PACKAGE";
    private static final String ACTION_CALCULATE = Constants.SERVER_PACKAGE.concat(".action.CALCULATE");
    public static final String ACTION_RESULT = Constants.SERVER_PACKAGE.concat(".action.RESULT");

    public static void runCalculationService(Context context, double number1, double number2, String operation) {
        Intent intent = new Intent();
        intent.setPackage(Constants.SERVER_PACKAGE);
        intent.setAction(ACTION_CALCULATE);
        intent.putExtra(EXTRA_NUM1, number1);
        intent.putExtra(EXTRA_NUM2, number2);
        intent.putExtra(EXTRA_OPERATION, operation);
        intent.putExtra(EXTRA_PACKAGE, context.getPackageName());
        context.sendBroadcast(intent);
    }
}
