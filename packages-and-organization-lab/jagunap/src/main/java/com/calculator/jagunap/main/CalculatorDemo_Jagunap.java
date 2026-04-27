package com.calculator.jagunap.main;

import com.calculator.jagunap.service.Calculator;
import com.calculator.jagunap.exception.*;

/**
 * Q1: How did you structure your packages?
 * A1: I grouped my packages into service, exception, and main to maintain a clean, organized, and modular project structure.
 *
 * Q2: What was the reason for separating your classes this way?
 * A2: The separation allows each class to focus on a single responsibility, making the code easier to maintain and understand.
 *
 * Q3: How do packages help with encapsulation?
 * A3: Packages organize related classes and control access through modifiers, reducing unwanted exposure of internal logic.
 *
 * Q4: Where did you place your exception classes?
 * A4: All exception classes are stored in the com.calculator.nono.exception package.
 *
 * Q5: Why did you select Maven or Gradle?
 * A5: I chose Gradle because it offers better performance, flexibility, and a more readable DSL compared to XML-based configurations.
 */
 
public class CalculatorDemo_Jagunap {
 
    public static void main(String[] args) {
 
        // Polymorphism:
        // Parent reference pointing to child object
        Calculator calculator = new Calculator();
 
        System.out.println("===== Calculator Demo Started =====");
 
        try {
            // ✅ Normal operations
            System.out.println("Addition (int): " + calculator.add(10, 5));
            System.out.println("Addition (double): " + calculator.add(2.5, 1.5));
            System.out.println("Subtraction: " + calculator.subtract(10, 3));
 
            // ✅ Valid multiplication
            System.out.println("Multiplication: " + calculator.multiply(4, 3));
 
            // ❌ Trigger CHECKED exception (division by zero)
            System.out.println("Division: " + calculator.divide(10, 0));
 
        }
        catch (InvalidInputExceptions e) {
            // Handles CHECKED exception
            System.err.println("ERROR (Invalid Input): " + e.getMessage());
 
        }
        catch (NegativeNumberExceptions e) {
            // Handles UNCHECKED exception
            System.err.println("ERROR (Negative Number): " + e.getMessage());
 
        }
        catch (Exception e) {
            // Safety net for unexpected exceptions
            System.err.println("Unexpected Error: " + e.getMessage());
 
        }
        finally {
            // ✅ Always executes
            System.out.println("===== Calculator Demo Finished =====");
        }
 
        /*
         -----------------------------------------------------
         Trigger UNCHECKED exception separately
         -----------------------------------------------------
         This block shows that unchecked exceptions
         can occur at runtime without 'throws'
        */
        try {
            System.out.println("Triggering Negative Number Exception:");
            System.out.println(calculator.multiply(-5, 2));
        }
        catch (NegativeNumberExceptions e) {
            System.err.println("ERROR (Negative Number): " + e.getMessage());
        }
 
    }
}