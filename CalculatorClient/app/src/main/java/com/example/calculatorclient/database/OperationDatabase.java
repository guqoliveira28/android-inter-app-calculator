package com.example.calculatorclient.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;

@Database(
        entities = {OperationEntity.class},
        version = 2,
        exportSchema = false
)
public abstract class OperationDatabase extends RoomDatabase {
    public abstract OperationDao operationDao();

    public static final Migration MIGRATION_1_2 = new DatabaseMigrationV1toV2();
}
