package com.example.calculatorserver.operations;

public class OperationFactory {

    public static OperationInterface getOperation(String operationType) {
        switch (operationType.toLowerCase()) {
            case "add":
                return new AddOperation();
            case "subtract":
                return new SubtractOperation();
            case "multiply":
                return new MultiplyOperation();
            case "divide":
                return new DivideOperation();
            default:
                throw new IllegalArgumentException("Invalid operation: " + operationType);
        }
    }
}
