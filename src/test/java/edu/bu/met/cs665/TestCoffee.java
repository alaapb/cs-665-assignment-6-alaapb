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
 * File Name: TestCoffee.java
 * Description: This file tests any cases related to creating a coffee drink such as incorrect user inputs
 */
public class TestCoffee {

    /**
     * This tests for the perfect user input for picking a coffee
     * The type, sugar level, and milk level is checked to see if it matches the input stream given
     */
  @Test
  public void testCoffeeValid() {
    ByteArrayInputStream inputStream = new ByteArrayInputStream("1\n2\n2\n".getBytes());
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    PrintStream ps = new PrintStream(outputStream);

    Coffee coffee = new Coffee(inputStream, ps);

    coffee.setType();
    coffee.setSugar();
    coffee.setMilk();

    assertEquals(coffee.getType(), "Americano");
    assertEquals(coffee.getSugar(), 2);
    assertEquals(coffee.getMilk(), 2);
  }

  /**
   * This tests for when an invalid coffee type is chosen and the user is requested for another input for the type
   */
  @Test
  public void testCoffeeInvalid() {
    ByteArrayInputStream inputStream = new ByteArrayInputStream("4\n2\n1\n2\n".getBytes());
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    PrintStream ps = new PrintStream(outputStream);

    Coffee coffee = new Coffee(inputStream, ps);

    coffee.setType();
    coffee.setSugar();
    coffee.setMilk();

    assertEquals(coffee.getType(), "Latte Macchiato");
    assertEquals(coffee.getSugar(), 1);
    assertEquals(coffee.getMilk(), 2);
  }

}
