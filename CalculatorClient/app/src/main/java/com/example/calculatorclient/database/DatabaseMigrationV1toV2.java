package com.example.calculatorclient.database;

import androidx.annotation.NonNull;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

public class DatabaseMigrationV1toV2 extends Migration {

    public DatabaseMigrationV1toV2() {
        super(1, 2);
    }

    // Migrating from version 1 to version 2
    // Result column is changed to TEXT (String)
    @Override
    public void migrate(@NonNull SupportSQLiteDatabase database) {
        database.execSQL("CREATE TABLE OperationEntity_temp (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                "number1 REAL NOT NULL, " +
                "number2 REAL NOT NULL, " +
                "operation TEXT, " +
                "result TEXT, " +
                "timestamp INTEGER NOT NULL)");

        database.execSQL("INSERT INTO OperationEntity_temp (id, number1, number2, operation, result, timestamp) " +
                "SELECT id, number1, number2, operation, CAST(result AS TEXT), timestamp FROM OperationEntity");

        database.execSQL("DROP TABLE OperationEntity");

        database.execSQL("ALTER TABLE OperationEntity_temp RENAME TO OperationEntity");
    }
}
