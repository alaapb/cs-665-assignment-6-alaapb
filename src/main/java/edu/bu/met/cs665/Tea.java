package edu.bu.met.cs665;

import java.io.InputStream;
import java.io.PrintStream;

/**
 * Name: Alaap Bharadwaj
 * Course: CS-665 Software Designs & Patterns
 * Date: 02/08/2023
 * File Name: Tea.java
 * Description: This file extends from the Beverage class. This file is for when the user create a tea drink.
 */
public class Tea extends Beverage implements CTStrategy {

    private final String[] types = {"Black Tea", "Green Tea", "Yellow Tea"};
    private String teaType;
    
    public Tea(InputStream inputStream, PrintStream printStream) {
        super(inputStream, printStream, "Tea");
    }

    /**
     * User picks the type of tea they want from given options
     * If user input is outside the range, they are prompted to try again until a correct option is given
     */
    public void setType() {
        
        System.out.println("Please Choose Type: Black Tea [0], Green Tea [1], Yellow Tea [2]");

        int userInput = in.nextInt();

        while(userInput >= types.length || userInput < 0) {
            System.out.println("Please Choose a type within the given options");

            System.out.println("Please Choose Type: Black Tea [0], Green Tea [1], Yellow Tea [2]");
            userInput = in.nextInt();
        }

        teaType = types[userInput];

        System.out.println(teaType + " has been chosen for coffee");
    }

    /**
     * Retrieves type of the coffee
     * @return String
     */
    public String getType() {
        return teaType;
    }
}
