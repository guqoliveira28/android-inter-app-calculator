package com.example.calculatorclient.database;

import android.content.Context;
import android.util.Log;

import androidx.room.Room;

import java.util.List;

public class OperationRepository {
    private final OperationDatabase db;
    private List<OperationEntity> operations;

    public OperationRepository(Context context) {
        db = Room.databaseBuilder(context, OperationDatabase.class, "OperationsDB")
                .build();
        Log.d("OperationRepository", "Database loaded");
        refreshOperations();
    }

    public void storeOperation(OperationEntity operation) {
        new Thread(() -> {
            db.operationDao().insert(operation);
            refreshOperations();
        }).start();
    }

    private void refreshOperations() {
        new Thread(() -> operations = db.operationDao().getAll()).start();
    }

    public interface OperationsFetchCallback {
        void onOperationsFetched(List<OperationEntity> data);
    }

    public void retrieveOperations(OperationsFetchCallback callback) {
        new Thread(() -> {
            operations = db.operationDao().getAll();
            callback.onOperationsFetched(operations);
        }).start();
    }
}
