package com.example.calculatorclient.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class OperationEntity implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "number1")
    private double number1;
    @ColumnInfo(name = "number2")
    private double number2;
    @ColumnInfo(name = "operation")
    private String operation;
    @ColumnInfo(name = "result")
    private double result;
    @ColumnInfo(name = "timestamp")
    private long timestamp;

    public OperationEntity(int id, double number1, double number2, String operation, double result, long timestamp) {
        this.id = id;
        this.number1 = number1;
        this.number2 = number2;
        this.operation = operation;
        this.result = result;
        this.timestamp = timestamp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getNumber1() {
        return number1;
    }

    public void setNumber1(double number1) {
        this.number1 = number1;
    }

    public double getNumber2() {
        return number2;
    }

    public void setNumber2(double number2) {
        this.number2 = number2;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
