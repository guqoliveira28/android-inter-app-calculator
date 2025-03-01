package com.example.calculatorclient.ui;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.calculatorclient.R;
import com.example.calculatorclient.database.OperationEntity;
import com.example.calculatorclient.database.OperationRepository;
import com.example.calculatorclient.receiver.CalculationResultReceiver;
import com.example.calculatorclient.utils.CalculationUtils;
import com.example.calculatorclient.utils.Constants;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private CalculationResultReceiver resultReceiver;

    private EditText number1Input;
    private EditText number2Input;
    private Spinner operationSpinner;
    private RecyclerView historyRecyclerView;

    private OperationRepository operationRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Initialize views
        number1Input = findViewById(R.id.number1Input);
        number2Input = findViewById(R.id.number2Input);
        operationSpinner = findViewById(R.id.operationSpinner);
        Button calculateButton = findViewById(R.id.calculateButton);
        TextView resultTextView = findViewById(R.id.resultTextView);
        historyRecyclerView = findViewById(R.id.historyView);

        historyRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        historyRecyclerView.setAdapter(new HistoryViewAdapter(new ArrayList<OperationEntity>()));

        calculateButton.setOnClickListener(v -> {
            Log.d("MainActivity", "Calculate button clicked");
            calculate();
        });

        // setup receiver
        resultReceiver = new CalculationResultReceiver(resultTextView, historyRecyclerView);

        // setup database
        operationRepository = new OperationRepository(this);

        startServerApp();
    }

    private void calculate() {
        String num1Str = number1Input.getText().toString();
        String num2Str = number2Input.getText().toString();

        if (num1Str.isEmpty() || num2Str.isEmpty()) {
            Toast.makeText(this, "Please enter both numbers", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            double num1 = Double.parseDouble(num1Str);
            double num2 = Double.parseDouble(num2Str);
            String selectedOperation = operationSpinner.getSelectedItem().toString().toLowerCase();

            resultReceiver.setOperation(num1, num2, selectedOperation);
            CalculationUtils.runCalculationService(this, num1, num2, selectedOperation);
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Invalid number format", Toast.LENGTH_SHORT).show();
        }
    }

    private void startServerApp() {
        Intent intent = new Intent();
        intent.setPackage(Constants.SERVER_PACKAGE);
        intent.setAction(Constants.SERVER_PACKAGE.concat(".action.START"));
        this.sendBroadcast(intent);
    }

    public void updateHistory() {
        HistoryViewAdapter adapter = (HistoryViewAdapter) historyRecyclerView.getAdapter();
        if (adapter != null) {
            operationRepository.retrieveOperations(data -> {
                Log.d("MainActivity", "Updating history");
                runOnUiThread(() -> {
                    adapter.setOperations(data);
                });
            });
        }
    }

    private void registerReceivers() {
        IntentFilter filter = new IntentFilter(CalculationUtils.ACTION_RESULT);
        ContextCompat.registerReceiver(this, resultReceiver, filter, ContextCompat.RECEIVER_EXPORTED);
    }

    private void unregisterReceivers() {
        unregisterReceiver(resultReceiver);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("MainActivity", "onResume");
        updateHistory();
        registerReceivers();
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceivers();
    }
}