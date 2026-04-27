package com.calculator.nono.main;

import com.calculator.nono.service.Calculator;
import com.calculator.nono.exception.*;

/**
 * Q1: How did you organize your packages?
 * A1: I organized my packages into service, exception, and main to follow a structured and modular design.
 *
 * Q2: Why did you separate your classes this way?
 * A2: I separated them to ensure each class has a clear responsibility and to improve maintainability.
 *
 * Q3: How do packages improve encapsulation?
 * A3: Packages group related classes and limit access using modifiers, preventing unnecessary exposure of logic.
 *
 * Q4: Where are your exceptions located?
 * A4: The exceptions are located in com.calculator.nono.exception.
 *
 * Q5: Why did you choose Maven or Gradle?
 * A5: I chose Gradle because it is faster, flexible, and uses a simpler DSL compared to XML.
 */

public class CalculatorDemo_Nono {

    public static void main(String[] args) {

       Calculator calc = new Calculator();

        System.out.println("=========== NONO CALC ===========\n");

        try {
            // ✅ Normal operations
            System.out.println("Add (int): " + calc.add(10, 5));
            System.out.println("Add (double): " + calc.add(2.5, 1.5));
            System.out.println("Subtract: " + calc.subtract(10, 3));

            // ❌ UNCHECKED exception
            System.out.println("Multiply: " + calc.multiply(-3, 13));

            // ❌ CHECKED exception
            System.out.println("Divide: " + calc.divide(10, 0));

        } catch (InvalidInputException e) {
            System.out.println("Checked Exception Caught: " + e.getMessage());

        } catch (NegativeNumberException e) {
            System.out.println("Unchecked Exception Caught: " + e.getMessage());

        } catch (Exception e) {
            System.out.println("General Error: " + e.getMessage());

        } finally {
            System.out.println("\nCleaning up resources...");
        }

        // Separate unchecked demo
        try {
            System.out.println("\nTriggering Negative Number Exception:");
            System.out.println(calc.multiply(-5, 2));
        } catch (NegativeNumberException e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        System.out.println("\n[Brought to you by NONO Calculator]");
    }
}