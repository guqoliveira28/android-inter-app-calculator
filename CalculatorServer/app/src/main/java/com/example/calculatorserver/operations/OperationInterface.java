package com.example.calculatorserver.operations;

import java.math.BigDecimal;

public interface OperationInterface {
    BigDecimal performOperation(double num1, double num2);
}
