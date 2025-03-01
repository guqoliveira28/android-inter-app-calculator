package com.example.calculatorserver.operations;

import junit.framework.TestCase;

public class SubtractOperationTest extends TestCase {

    public void testPerformOperation() {
        SubtractOperation subtractOperation = new SubtractOperation();
        double result = subtractOperation.performOperation(10.1, 4.4);
        assertEquals(5.7, result, 0.001);
    }

    public void testPerformOperationWithNegativeNumbers() {
        SubtractOperation subtractOperation = new SubtractOperation();
        double result = subtractOperation.performOperation(-5.0, 3.0);
        assertEquals(-8.0, result, 0.001);
    }

    public void testPerformOperationWithNegativeNumbers2() {
        SubtractOperation subtractOperation = new SubtractOperation();
        double result = subtractOperation.performOperation(-5.0, -8.0);
        assertEquals(3.0, result, 0.001);
    }
}