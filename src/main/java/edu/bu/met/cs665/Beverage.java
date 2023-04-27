package edu.bu.met.cs665;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * Name: Alaap Bharadwaj
 * Course: CS-665 Software Designs & Patterns
 * Date: 02/08/2023
 * File Name: Beverage.java
 * Description: This file is a super class for beverage and since all beverages get an option of condiments the condiments interface is also implemented in this file
 */
public abstract class Beverage implements Condiments{
    private int sugar;
    private int milk;
    protected Scanner in;
    private String name;


    protected PrintStream printStream;
    
    public Beverage(InputStream inputStream, PrintStream printStream, String name) {
        super();
        this.name = name;
        this.printStream = printStream;
        this.in = new Scanner(inputStream);
        sugar = 0;
        milk = 0;

    }

    /**
     * Gets user input for sugar level 0-3
     * If incorrect input is given, either the min or max is chosen depending on which is close to the user input
     */
    @Override
    public void setSugar() {
        printStream.println("Please Enter Amoung of Sugar (0-3)");
        sugar = in.nextInt();

        if(sugar > 3) {
            sugar = 3;
            printStream.println("Max Sugar Amount is 3, only 3 has been added!");
        }else if(sugar < 0) {
            sugar = 0;
            printStream.println("Amount below 0 cannot be added, so no sugar has been added!");
        }
        printStream.println("Sugar Amount Entered is " + sugar);
    }

    /**
     * Retrieves sugar level for the beverage
     * @return int
     */
    @Override
    public int getSugar() {
        return sugar;
    }

    /**
     * Gets user input for milk level
     * If incorrect input, either the min or max is chosen depending on which is close to the user input
     */
    @Override
    public void setMilk() {
        printStream.println("Please Enter Amount of Milk (0-3)");
        milk = in.nextInt();

        if(milk > 3) {
            milk = 3;
            printStream.println("Max Milk Amount is 3, only 3 has been added!");
        }else if(milk < 0) {
            milk = 0;
            printStream.println("Amount below 0 cannot be added, so no milk has been added!");
        }

        printStream.println("Milk Amount Entered is " + milk);
    }

    /**
     * Retrieves milk level for the beverage
     * @return int
     */
    @Override
    public int getMilk() {
        return milk;
    }

    /**
     * Retrieves name of the drink
     * @return String
     */
    public String getName() {
        return name;
    }
}
