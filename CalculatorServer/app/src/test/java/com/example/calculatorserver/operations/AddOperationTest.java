package com.example.calculatorserver.operations;

import junit.framework.TestCase;

import java.math.BigDecimal;

public class AddOperationTest extends TestCase {

    public void testPerformOperation() {
        BigDecimal expected = new BigDecimal(9);
        AddOperation addOperation = new AddOperation();
        BigDecimal result = addOperation.performOperation(5.5, 3.5);
        assertEquals(expected, result);
    }

    public void testPerformOperation2() {
        BigDecimal expected = new BigDecimal("6.3");
        AddOperation addOperation = new AddOperation();
        BigDecimal result = addOperation.performOperation(10.5, -4.2);
        assertEquals(expected, result);
    }
}