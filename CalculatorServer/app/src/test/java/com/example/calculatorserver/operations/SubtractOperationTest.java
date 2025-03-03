package com.example.calculatorserver.operations;

import junit.framework.TestCase;

import java.math.BigDecimal;

public class SubtractOperationTest extends TestCase {

    public void testPerformOperation() {
        BigDecimal expected = new BigDecimal("5.7");
        SubtractOperation subtractOperation = new SubtractOperation();
        BigDecimal result = subtractOperation.performOperation(10.1, 4.4);
        assertEquals(expected, result);
    }

    public void testPerformOperationWithNegativeNumbers() {
        BigDecimal expected = new BigDecimal(-8);
        SubtractOperation subtractOperation = new SubtractOperation();
        BigDecimal result = subtractOperation.performOperation(-5.0, 3.0);
        assertEquals(expected, result);
    }

    public void testPerformOperationWithNegativeNumbers2() {
        BigDecimal expected = new BigDecimal(3);
        SubtractOperation subtractOperation = new SubtractOperation();
        BigDecimal result = subtractOperation.performOperation(-5.0, -8.0);
        assertEquals(expected, result);
    }
}