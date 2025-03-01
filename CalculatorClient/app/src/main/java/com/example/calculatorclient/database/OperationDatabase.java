package com.example.calculatorclient.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {OperationEntity.class}, version = 1, exportSchema = false)
public abstract class OperationDatabase extends RoomDatabase {
    public abstract OperationDao operationDao();
}
