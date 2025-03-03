package com.example.calculatorserver.operations;

import junit.framework.TestCase;

import java.math.BigDecimal;

public class DivideOperationTest extends TestCase {

    public void testPerformOperation() {
        BigDecimal expected = new BigDecimal(5);
        DivideOperation divideOperation = new DivideOperation();
        BigDecimal result = divideOperation.performOperation(10.0, 2.0);
        assertEquals(expected, result);
    }

    public void testPerformOperation2() {
        BigDecimal expected = new BigDecimal("1.71875");
        DivideOperation divideOperation = new DivideOperation();
        BigDecimal result = divideOperation.performOperation(55.0, 32.0);
        assertEquals(expected, result);

    }

    public void testPerformOperationWithZeroDenominator() {
        DivideOperation divideOperation = new DivideOperation();
        try {
            divideOperation.performOperation(10.0, 0.0);
            fail("Expected ArithmeticException to be thrown");
        } catch (ArithmeticException e) {
            assertEquals("Division by zero is not allowed.", e.getMessage());
        }
    }
}