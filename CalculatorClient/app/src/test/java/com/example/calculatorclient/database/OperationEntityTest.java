package com.example.calculatorclient.database;

import junit.framework.TestCase;

import java.util.Date;

public class OperationEntityTest extends TestCase {
    private OperationEntity operation;
    private long timestamp;

    public void setUp() throws Exception {
        super.setUp();
        timestamp = new Date().getTime();
        operation = new OperationEntity(
                0, 10.0, 5.0, "add", "15", timestamp);
    }

    public void testGetId() {
        assertEquals(0, operation.getId());
    }

    public void testSetId() {
        operation.setId(1);
        assertEquals(1, operation.getId());
    }

    public void testGetNumber1() {
        assertEquals(10.0, operation.getNumber1(), 0.001);
    }

    public void testSetNumber1() {
        operation.setNumber1(15.0);
        assertEquals(15.0, operation.getNumber1(), 0.001);
    }

    public void testGetNumber2() {
        assertEquals(5.0, operation.getNumber2(), 0.001);
    }

    public void testSetNumber2() {
        operation.setNumber2(20.0);
        assertEquals(20.0, operation.getNumber2(), 0.001);
    }

    public void testGetOperation() {
        assertEquals("add", operation.getOperation());
    }

    public void testSetOperation() {
        operation.setOperation("subtract");
        assertEquals("subtract", operation.getOperation());
    }

    public void testGetResult() {
        assertEquals("15", operation.getResult());
    }

    public void testSetResult() {
        operation.setResult("20");
        assertEquals("20", operation.getResult());
    }

    public void testGetTimestamp() {
        assertEquals(timestamp, operation.getTimestamp());
    }

    public void testSetTimestamp() {
        long newTimestamp = new Date().getTime();
        operation.setTimestamp(newTimestamp);
        assertEquals(newTimestamp, operation.getTimestamp());
    }
}