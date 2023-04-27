package edu.bu.met.cs665;

import java.io.InputStream;
import java.io.PrintStream;

/**
 * Name: Alaap Bharadwaj
 * Course: CS-665 Software Designs & Patterns
 * Date: 02/08/2023
 * File Name: Coffee.java
 * Description: This file extends from the Beverage class. This file is for when the user create a coffee drink.
 */
public class Coffee extends Beverage implements CTStrategy {

    private final String[] types = {"Espresso", "Americano", "Latte Macchiato"};

    private String coffeeType;

    public Coffee(InputStream inputStream, PrintStream printStream) {
        super(inputStream, printStream, "Coffee");

    }

    /**
     * User picks the type of coffee they want from given options
     * If user input is outside the range, they are prompted to try again until a correct option is given
     */
    public void setType() {
        
        printStream.println("Please Choose Type: Espresso [0], Americano [1], Latte Macchiato [2]");
        int userInput = in.nextInt();

        while(userInput >= types.length || userInput < 0) {
            printStream.println("Please Choose a type within the given options");

            printStream.println("Please Choose Type: Espresso [0], Americano [1], Latte Macchiato [2]");
            userInput = in.nextInt();
        }

        coffeeType = types[userInput];

        printStream.println(coffeeType + " has been chosen for coffee");
    }

    /**
     * Retrieves type of the coffee
     * @return String
     */
    public String getType() {
        return coffeeType;
    }


    
}
