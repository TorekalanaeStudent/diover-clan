package com.calculator.trespeces.main;

import com.calculator.trespeces.service.BasicCalculator;
import com.calculator.trespeces.exception.DivisionByZeroException;
import com.calculator.trespeces.exception.InvalidInputException;
import com.calculator.trespeces.exception.NegativeNumberException;

// Code-Based Analysis
/**
 * Q1: How did you organize your packages?
 * A1: I organized my packages by creating separate folders for each layer
 *     like service, exception, and main so each one has its own job.
 *
 * Q2: Why did you separate your classes this way?
 * A2: I separated them this way because each class should only be responsible
 *     for one thing so it is easier to find and fix stuff later.
 *
 * Q3: How do packages improve encapsulation?
 * A3: Packages improve encapsulation by keeping related classes together
 *     and hiding what other packages don't need to see.
 *
 * Q4: Where are your exceptions located?
 * A4: My exceptions are located in com.calculator.trespeces.exception
 *
 * Q5: Why did you choose Gradle?
 * A5: I chose Gradle because it is faster than Maven and the build file
 *     is simpler and easier to understand compared to XML.
 */

public class CalculatorDemo_Trespeces {
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
