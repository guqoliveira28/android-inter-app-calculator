package com.example.calculatorserver.operations;

import junit.framework.TestCase;

public class MultiplyOperationTest extends TestCase {

    public void testPerformOperation() {
        MultiplyOperation multiplyOperation = new MultiplyOperation();
        double result = multiplyOperation.performOperation(2.5, 2);
        assertEquals(5.0, result, 0.001);
    }
}