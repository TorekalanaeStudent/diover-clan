package com.calculator.caneda.main;

import com.calculator.caneda.service.SimpleCalculator;
import com.calculator.caneda.exception.*; // did not import them 1 by 1 since its js 2 and we need both

// Code-Based Analysis
/**
 * Q1: How did you organize your packages?
 * A1: I managed my packages by creating multiple folders that simulates real world applications
 * 
 * Q2: Why did you separate your classes this way?
 * A2: To learn more about how reql world applications work and how they're properly organized
 * 
 * Q3: How do packages improve encapsulation?
 * A3: Packages improve encapsulation by making it so every package has their own responsibility and not just one package having every responsibility
 * 
 * Q4: Where are your exceptions located?
 * A4: The exceptions are located in com.calculator.canillo.exceptions
 * 
 * Q5: Why did you choose Maven or Gradle?
 * A5: I chose Gradle because firstly, its faster, second I like DSL more than XML
 * 
 */

public class CalculatorDemo_Caneda {
    public static void main(String[] args) {

        SimpleCalculator calc = new SimpleCalculator();

        System.out.println("=========== CANEDA CALC ===========\n(calc is short for calculator btw if u guys dont know)\n");

        try {
            // normal operation stuff
            System.out.println("Add: " + calc.add(1, 66));
            System.out.println("Subtract: " + calc.subtract(100, 33));

            // triggering unchecked exception
            System.out.println("Multiply: " + calc.multiply(-3, 13)); // will need to comment this so u can get to the checked exception
                                                                      // its just for demo so we dont really need to make this 
                                                                      // complicated 
            // triggering checked exception
            System.out.println("Divide: " + calc.divide(10, 0)); 

        } catch (ZeroDivisionException e) {
            System.out.println("Checked Exception Caught: " + e.getMessage());

        } catch (NegativeNumberException e) {
            System.out.println("Unchecked Exception Caught: " + e.getMessage());

        } catch (Exception e) {
            System.out.println("General Error: " + e.getMessage());

        } finally {
            System.out.println("Operations attempted: " + calc.getOperationCount());
            System.out.println("\nCleaning up resources..."); // just to make it cooler
        }

        System.out.println("\n[Brought to you by " + calc.getName() + "]");
    }
}
