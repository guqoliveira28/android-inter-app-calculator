package com.example.calculatorserver;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.example.calculatorserver.service.CalculationService;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart()");
        Intent serviceIntent = new Intent(this, CalculationService.class);
        serviceIntent.setComponent(new ComponentName(this, CalculationService.class));
        startForegroundService(serviceIntent);
    }

    @Override
    protected void onStop() {
        super.onStop();
    }
}
