package com.example.calculatorserver.operations;

public class MultiplyOperation implements OperationInterface {
    @Override
    public double performOperation(double num1, double num2) {
        return num1 * num2;
    }
}
