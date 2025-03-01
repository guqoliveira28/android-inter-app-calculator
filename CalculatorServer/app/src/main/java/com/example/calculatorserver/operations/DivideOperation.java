package com.example.calculatorserver.operations;

public class DivideOperation implements OperationInterface {
    @Override
    public double performOperation(double num1, double num2) {
        if (num2 == 0) {
            throw new ArithmeticException("Division by zero is not allowed.");
        }

        return num1 / num2;
    }
}
