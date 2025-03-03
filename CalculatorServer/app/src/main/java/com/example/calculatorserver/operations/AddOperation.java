package com.example.calculatorserver.operations;

import java.math.BigDecimal;

public class AddOperation extends BaseOperation {

    @Override
    protected BigDecimal performCalculation(double num1, double num2) {
        return new BigDecimal(String.valueOf(num1))
                .add(new BigDecimal(String.valueOf(num2)));
    }
}
