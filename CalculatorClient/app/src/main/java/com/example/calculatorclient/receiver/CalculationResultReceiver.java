package com.example.calculatorclient.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.calculatorclient.R;
import com.example.calculatorclient.database.OperationEntity;
import com.example.calculatorclient.database.OperationRepository;
import com.example.calculatorclient.ui.HistoryViewAdapter;
import com.example.calculatorclient.ui.SimpleAlertDialog;
import com.example.calculatorclient.utils.CalculationUtils;

import java.util.Date;

public class CalculationResultReceiver extends BroadcastReceiver {

    private final TextView resultTextView;
    private final RecyclerView historyView;

    private double number1;
    private double number2;
    private String operation;

    public CalculationResultReceiver(TextView resultTextView, RecyclerView recyclerView) {
        this.resultTextView = resultTextView;
        this.historyView = recyclerView;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("CalculationResultReceiver", "onReceive");
        if (CalculationUtils.ACTION_RESULT.equals(intent.getAction())) {
            String EXTRA_RESULT = "RESULT";
            String EXTRA_ERROR = "ERROR";
            String error = intent.getStringExtra(EXTRA_ERROR);
            if (error != null) {
                resultTextView.setText(R.string.errorMsg);
                SimpleAlertDialog dialog = new SimpleAlertDialog(
                        context, context.getResources().getString(R.string.errorMsg), error);
                dialog.show();
                return;
            }
            double result = intent.getDoubleExtra(EXTRA_RESULT, 0);
            resultTextView.setText(String.valueOf(result));

            Log.d("CalculationResultReceiver", "Storing operation");

            OperationRepository operationRepository = new OperationRepository(context);

            OperationEntity operationEntity = new OperationEntity(
                    0, number1, number2, operation, result, (new Date()).getTime());
            operationRepository.storeOperation(operationEntity);

            new Handler(Looper.getMainLooper()).post(() -> {
                HistoryViewAdapter adapter = (HistoryViewAdapter) historyView.getAdapter();
                if (adapter != null) {
                    adapter.addOperation(operationEntity);
                }
            });
        }
    }

    public void setOperation(double number1, double number2, String operation) {
        this.number1 = number1;
        this.number2 = number2;
        this.operation = operation;
    }
}
