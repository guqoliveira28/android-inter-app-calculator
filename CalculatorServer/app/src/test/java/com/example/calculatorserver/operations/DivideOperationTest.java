package com.example.calculatorserver.operations;

import junit.framework.TestCase;

public class DivideOperationTest extends TestCase {

    public void testPerformOperation() {
        DivideOperation divideOperation = new DivideOperation();
        double result = divideOperation.performOperation(10, 2);
        assertEquals(5.0, result, 0.001);
    }

    public void testPerformOperation2() {
        DivideOperation divideOperation = new DivideOperation();
        double result = divideOperation.performOperation(55, 32);
        assertEquals(1.71875, result, 0.00001);
    }

    public void testPerformOperationWithZeroDenominator() {
        DivideOperation divideOperation = new DivideOperation();
        try {
            divideOperation.performOperation(10, 0);
            fail("Expected ArithmeticException to be thrown");
        } catch (ArithmeticException e) {
            assertEquals("Division by zero is not allowed.", e.getMessage());
        }
    }
}