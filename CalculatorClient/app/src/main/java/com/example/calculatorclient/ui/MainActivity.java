package com.example.calculatorclient.ui;

import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.calculatorclient.R;
import com.example.calculatorclient.utils.CalculationResultReceiver;
import com.example.calculatorclient.utils.CalculationUtils;

public class MainActivity extends AppCompatActivity {

    private CalculationResultReceiver resultReceiver;

    private EditText number1Input;
    private EditText number2Input;
    private Spinner operationSpinner;
    private Button calculateButton;
    private TextView resultTextView;

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

        number1Input = findViewById(R.id.number1Input);
        number2Input = findViewById(R.id.number2Input);
        operationSpinner = findViewById(R.id.operationSpinner);
        calculateButton = findViewById(R.id.calculateButton);
        resultTextView = findViewById(R.id.resultTextView);

        calculateButton.setOnClickListener(v -> {
            calculate();
        });

        resultReceiver = new CalculationResultReceiver(resultTextView);
    }

    private void calculate() {
        String num1Str = number1Input.getText().toString();
        String num2Str = number2Input.getText().toString();

        if (num1Str.isEmpty() || num2Str.isEmpty()) {
            Toast.makeText(this, "Please enter both numbers", Toast.LENGTH_SHORT).show();
            return;
        }

        double num1 = Double.parseDouble(num1Str);
        double num2 = Double.parseDouble(num2Str);
        String selectedOperation = operationSpinner.getSelectedItem().toString().toLowerCase(); // Get selected operation

        CalculationUtils.startCalculationService(this, num1, num2, selectedOperation);
    }

    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter filter = new IntentFilter(CalculationUtils.ACTION_RESULT); // Use the action string
        registerReceiver(resultReceiver, filter, RECEIVER_EXPORTED);
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(resultReceiver);
    }
}