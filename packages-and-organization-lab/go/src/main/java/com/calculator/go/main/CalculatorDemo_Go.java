package com.calculator.go.main;

import com.calculator.go.service.*;
import com.calculator.go.exception.*;

//Code-Based Analysis
/*
 * Q1: How did you organize your packages?
 * A1: I organized my packages by separating them into multiple folders that imitate how real-world applications are usually structured, these organization methods are also very reminiscient of the paths where one would mod applications.
 * 
 * Q2: Why did you separate your classes this way?
 * A2: I separated the classes in this method so that one, or many, could better understand how real-world applications are arranged and properly managed.
 * 
 * Q3: How do packages improve encapsulation?
 * A3: Packages improve encapsulation by giving each package its own responsibility instead of placing everything inside a singular package.
 * 
 * Q4: Where are your exceptions located?
 * A4: My exceptions are located in "com.calculator.go.exceptions;".
 * 
 * Q5: Why did you choose Maven or Gradle?
 * A5: I chose Gradle because it is faster and has a lower learning curve(for the meantime)
 * 
 */

public class CalculatorDemo_Go {
    public static void main(String[] args) {
      
        BasicCalculator calc = new BasicCalculator();

        // addition - overloaded (int)
        System.out.println("=== Addition (int) ===");
        int intResult = calc.addition(5, 3);
        System.out.println("5 + 3 = " + intResult);

        // addition - overloaded (double)
        System.out.println("\n=== Addition (double) ===");
        double doubleResult = calc.addition(5.5, 3.3);
        System.out.println("5.5 + 3.3 = " + doubleResult);

        // subtraction
        System.out.println("\n=== Subtraction ===");
        System.out.println("10.0 - 4.0 = " + calc.subtraction(10.0, 4.0));

        // multiplication
        System.out.println("\n=== Multiplication ===");
        System.out.println("6.0 * 7.0 = " + calc.multiplication(6.0, 7.0));

        // division - valid
        System.out.println("\n=== Division ===");
        try {
            System.out.println("10.0 / 2.0 = " + calc.division(10.0, 2.0));
        } catch (DivisionByZeroException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Division attempt complete.");
        }

        // division by zero - triggers DivisionByZeroException
        System.out.println("\n=== Division by Zero ===");
        try {
            System.out.println(calc.division(10.0, 0));
        } catch (DivisionByZeroException e) {
            System.out.println("Caught: " + e.getMessage());
        } finally {
            System.out.println("Division attempt complete.");
        }

        // validate - triggers InvalidInputException
        System.out.println("\n=== Invalid Input ===");
        try {
            calc.validate(0);
        } catch (InvalidInputException e) {
            System.out.println("Caught: " + e.getMessage());
        } catch (NegativeNumberException e) {
            System.out.println("Caught: " + e.getMessage());
        } finally {
            System.out.println("Validation complete.");
        }

        // validate - triggers NegativeNumberException
        System.out.println("\n=== Negative Number ===");
        try {
            calc.validate(-5);
        } catch (InvalidInputException e) {
            System.out.println("Caught: " + e.getMessage());
        } catch (NegativeNumberException e) {
            System.out.println("Caught: " + e.getMessage());
        } finally {
            System.out.println("Validation complete.");
        }

        System.out.println("\n=== DEMO Completed ===");
    }
}