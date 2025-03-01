package com.example.calculatorserver.operations;

import junit.framework.TestCase;

public class AddOperationTest extends TestCase {

    public void testPerformOperation() {
        AddOperation addOperation = new AddOperation();
        double result = addOperation.performOperation(5.5, 3.5);
        assertEquals(9.0, result, 0.001);
    }

    public void testPerformOperation2() {
        AddOperation addOperation = new AddOperation();
        double result = addOperation.performOperation(10.5, -4.2);
        assertEquals(6.3, result, 0.001);
    }
}