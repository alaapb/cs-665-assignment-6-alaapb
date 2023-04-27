package edu.bu.met.cs665;

import java.util.Scanner;

/**
 * Name: Alaap Bharadwaj
 * Course: CS-665 Software Designs & Patterns
 * Date: 02/08/2023
 * File Name: Run.java
 * Description: This file is like the brains of the application, where user input is taken and different beverages are made.
 * This class acts as a barista in an actual Coffee Shop.
 */
public class Run {

    Beverage curBeverage;

    private Scanner in;
    
    /**
     * This method initializes the variables within the class and calls methods to begin the vending process
     */
    public Run() {
        super();
        in = new Scanner(System.in);

        begin();
        beverageHandler();
    }

    /**
     * Void method to display welcome message
     * Added as a different method for flexibility to expand to a GUI in the future
     */
    private void begin() {
        // This will introduce the application with a welcome screen
        // Made into a separate method to enhance flexibility and maybe expansion to GUI in the future

        System.out.println("Welcome to Coffee/Tea Vending Machine");
        System.out.println("Please Follow the prompts below to order a drink");
    }

    /**
     * Main Beverage handler, contains while loop for the whole process of the vending machine
     * Takes in user input to then create various beverages and create them
     */
    private void beverageHandler() {
        // This will help choose the beverage
        // Will be given the choice between coffee and tea
        // Instance of coffee or tea is created and then later used
        // then given the choice to get another one or exit
        
        System.out.println("Order a Drink [0] or Exit [1]");
        int exitFlag = in.nextInt();
        
        while(exitFlag != 1) {
            System.out.println("Please choose between Coffee [0] or Tea [1]");
            int inputBeverage = in.nextInt();

            while(inputBeverage != 1 && inputBeverage != 0) {
                System.out.println("Please Choose a type within the given options");

                System.out.println("Please choose between Coffee [0] or Tea [1]");
                inputBeverage = in.nextInt();
            }

            if(inputBeverage == 0) {
                createCoffee();
            }else{
                createTea();
            }
            System.out.println("Order another drink [0] or exit [1]");
            exitFlag = in.nextInt();
        }

        // Pick Type of Coffee or Tea

    }

    /**
     * Create Coffee instance
     */
    private void createCoffee() {
        Coffee newCof = new Coffee(System.in, System.out);

        newCof.setType();
        newCof.setMilk();
        newCof.setSugar();

        printResult(newCof.getType(), newCof.getSugar(), newCof.getMilk());
    }

    /**
     * Create Tea instance
     */
    private void createTea() {
        Tea newTea = new Tea(System.in, System.out);

        newTea.setType();
        newTea.setMilk();
        newTea.setSugar();

        printResult(newTea.getType(), newTea.getSugar(), newTea.getMilk());
    }

    /**
     * Prints result after drink has been created by the user
     * 
     * @param type
     * @param sugar
     * @param milk
     */
    private void printResult(String type, int sugar, int milk) {
        System.out.println("Currently Dispensing: " + type + " with " + sugar + " sugar and " + milk + " milk");
    }
}
