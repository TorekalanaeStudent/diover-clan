package com.calculator.onte.main;


import com.calculator.onte.service.PlainCalculator;
import com.calculator.onte.exception.*;

/**
 * Code-Based Analysis
 * Q1: How did you organize your packages?
 * A1: I organized my packages my creating multiple folder like how we organize folders in real life.
 * 
 * Q2: Why did you separate your classes this way?
 * A2: To mirror how we separate folders in real life for their own purposes. For example we separate important papers from less important papers and we use 2 folders for that.
 * 
 * Q3: How do packages improve encapsulation?
 * A3: Packages improves encapsulation by making each folder have their one responsibility and not packing everything in 1 folder.
 * 
 * Q4: Where are your exceptions located?
 * A4: The exceptions thrown are located in com.calculator.onte.exception
 * 
 * Q5: Why did you choose Maven or Gradle?
 * A5: I chose Gradle because it is considered faster than Maven.
 */

public class CalculatorDemo_Onte {

    public static void main(String[] args) {

        PlainCalculator calc = new PlainCalculator("Basic Calculator");

        // First set
        try {
            System.out.println("Calculator: " + calc.getName());
            System.out.println("Add: " + calc.add(10, 5));
            System.out.println("Subtract: " + calc.subtract(10, 3));
            System.out.println("Multiply: " + calc.multiply(4, 2));

            System.out.println("Divide: " + calc.divide(10, 0));

        } catch (DivideByZeroException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("First set done.\n");
        }

        // Second set
        try {
            System.out.println("Add (double): " + calc.add(2.5, 3.5));

            calc.validateInput(-5);

        } catch (NegativeNumException e) {
            System.out.println("Validation Error: " + e.getMessage());
        }

        // Final outputs
        System.out.println("\nLast Result: " + calc.getLastResult());

        calc.clear();
        System.out.println("After clear: " + calc.getLastResult());
    }
}