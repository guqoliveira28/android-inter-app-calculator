package com.example.calculatorserver.operations;

import junit.framework.TestCase;

import java.math.BigDecimal;

public class MultiplyOperationTest extends TestCase {

    public void testPerformOperation() {
        BigDecimal expected = new BigDecimal(5);
        MultiplyOperation multiplyOperation = new MultiplyOperation();
        BigDecimal result = multiplyOperation.performOperation(2.5, 2);
        assertEquals(expected, result);
    }

    public void testPerformOperation2() {
        BigDecimal expected = new BigDecimal("2006.8");
        MultiplyOperation multiplyOperation = new MultiplyOperation();
        BigDecimal result = multiplyOperation.performOperation(58, 34.6);
        assertEquals(expected, result);
    }

    public void testPerformOperationWithZero() {
        BigDecimal expected = new BigDecimal(0);
        MultiplyOperation multiplyOperation = new MultiplyOperation();
        BigDecimal result = multiplyOperation.performOperation(0, 5);
        assertEquals(expected, result);
    }

    public void testPerformOperationWithNegative() {
        BigDecimal expected = new BigDecimal(-6);
        MultiplyOperation multiplyOperation = new MultiplyOperation();
        BigDecimal result = multiplyOperation.performOperation(-3, 2);
        assertEquals(expected, result);
    }
}