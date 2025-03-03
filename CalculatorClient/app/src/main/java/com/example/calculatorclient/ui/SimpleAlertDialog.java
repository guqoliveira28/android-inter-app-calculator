package com.example.calculatorclient.ui;

import android.app.AlertDialog;
import android.content.Context;

public class SimpleAlertDialog {
    private final AlertDialog dialog;

    public SimpleAlertDialog(Context context, String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);

        builder.setTitle(title);
        builder.setMessage(message);

        builder.setNeutralButton("Ok", (dialog, which) -> dialog.dismiss());

        dialog = builder.create();
    }

    public void show() {
        dialog.show();
    }
}
