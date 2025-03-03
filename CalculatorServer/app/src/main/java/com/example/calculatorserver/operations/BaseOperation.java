package com.example.calculatorserver.operations;

import java.math.BigDecimal;
import java.math.RoundingMode;

public abstract class BaseOperation implements OperationInterface {

    @Override
    public BigDecimal performOperation(double num1, double num2) {
        BigDecimal result = performCalculation(num1, num2);
        return formatResult(result);
    }

    protected abstract BigDecimal performCalculation(double num1, double num2);

    private BigDecimal formatResult(BigDecimal result) {
        if (result.scale() <= 0) {
            return result.setScale(0, RoundingMode.DOWN);
        } else {
            return result.stripTrailingZeros();
        }
    }
}
