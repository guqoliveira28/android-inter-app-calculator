package com.example.calculatorclient.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface OperationDao {

    @Query("SELECT * FROM operationentity ORDER BY timestamp DESC")
    List<OperationEntity> getAll();

    @Query("SELECT * FROM operationentity WHERE id = :id")
    OperationEntity findById(int id);

    @Insert
    void insert(OperationEntity operation);

    @Update
    void update(OperationEntity operation);

    @Delete
    void delete(OperationEntity operation);
}
