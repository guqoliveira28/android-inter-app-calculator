package com.example.calculatorserver.operations;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class DivideOperation extends BaseOperation {
    @Override
    protected BigDecimal performCalculation(double num1, double num2) {
        if (num2 == 0) {
            throw new ArithmeticException("Division by zero is not allowed.");
        }

        return new BigDecimal(String.valueOf(num1))
                .divide(new BigDecimal(String.valueOf(num2)), 6, RoundingMode.HALF_UP);
    }
}
