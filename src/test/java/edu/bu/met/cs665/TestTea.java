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
 * File Name: TestTea.java
 * Description: This file tests any cases related to making a tea drink
 */
public class TestTea {
    
    /**
     * This tests for a valid case of when the user picks to create a tea drink
     */
    @Test
    public void testTeaValid() {
        ByteArrayInputStream inputStream = new ByteArrayInputStream("1\n2\n2\n".getBytes());
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(outputStream);

        Tea tea = new Tea(inputStream, ps);

        tea.setType();
        tea.setSugar();
        tea.setMilk();


        assertEquals(tea.getType(), "Green Tea");
        assertEquals(tea.getSugar(), 2);
        assertEquals(tea.getMilk(), 2);
    }

    /**
     * This test checks for when an invalid case is made, for example,
     * they chose a type outside the range, therefore, making them choose again
     * with the specified input stream we know what inputs it should take for a successful invalid input
     */
    @Test
    public void testTestInvalid() {
        ByteArrayInputStream inputStream = new ByteArrayInputStream("3\n2\n1\n0\n".getBytes());
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(outputStream);

        Tea tea = new Tea(inputStream, ps);

        tea.setType();
        tea.setSugar();
        tea.setMilk();

        assertEquals(tea.getType(), "Yellow Tea");
        assertEquals(tea.getSugar(), 1);
        assertEquals(tea.getMilk(), 0);
    }
}
