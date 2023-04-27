package edu.bu.met.cs665;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

/**
 * Name: Alaap Bharadwaj
 * Course: CS-665 Software Designs & Patterns
 * Date: 02/08/2023
 * File Name: TestCondiments.java
 * Description: This file tests for cases with different inputs to test application of handling wrong inputs and correct inputs
 */
public class TestCondiments {

    /**
     * Testing inputs from the user, base correctness for condiments
     */
    @Test
    public void testCondimentsValid() {
        ByteArrayInputStream inputStream = new ByteArrayInputStream("0\n1\n2\n".getBytes());
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(outputStream);

        Coffee coffee = new Coffee(inputStream, ps);

        coffee.setType();
        coffee.setSugar();
        coffee.setMilk();

        assertEquals(coffee.getType(), "Espresso");
        assertEquals(coffee.getSugar(), 1);
        assertEquals(coffee.getMilk(), 2);
    }

    /**
     * Tests for a case when user inputs outside the given range, and if the condiments are placed at the min and the max accordingly
     */
    @Test
    public void testCondimentsInvalid() {
        ByteArrayInputStream inputStream = new ByteArrayInputStream("2\n-1\n5\n".getBytes());
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(outputStream);

        Coffee coffee = new Coffee(inputStream, ps);

        coffee.setType();
        coffee.setSugar();
        coffee.setMilk();

        assertEquals(coffee.getType(), "Latte Macchiato");
        assertEquals(coffee.getSugar(), 0);
        assertEquals(coffee.getMilk(), 3);
    }
}
