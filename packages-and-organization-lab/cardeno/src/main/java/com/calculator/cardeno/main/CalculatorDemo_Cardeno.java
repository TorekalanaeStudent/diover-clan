package com.calculator.cardeno.main;

import com.calculator.cardeno.service.Calculator;
import com.calculator.cardeno.exception.InvalidInputExceptions;
import com.calculator.cardeno.exception.NegativeNumberExceptions;

public class CalculatorDemo_Cardeno {

    public static void main(String[] args) {

        Calculator calc = new Calculator();

        System.out.println("--- Calculator Demo ---");

        // normal operations
        System.out.println("Addition (int): " + calc.add(5, 3));
        System.out.println("Addition (double): " + calc.add(2.5, 1.5));
        System.out.println("Subtraction: " + calc.subtract(10, 4));

        // multiplication with runtime exception
        try {
            System.out.println("Multiplication: " + calc.multiply(3, 4));
            System.out.println("Multiplication with negative: " + calc.multiply(-2, 5));
        } catch (NegativeNumberExceptions e) {
            System.out.println("Error: " + e.getMessage());
        }

        // division with checked exception
        try {
            System.out.println("Division: " + calc.divide(10, 2));
            System.out.println("Division by zero: " + calc.divide(10, 0));
        } catch (InvalidInputExceptions e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("--- End of demo ---");
    }
}

/*
 * - CODE-BASED ANALYSIS -
 *
 * 1. How did you organize your packages?
 * - I organized my project into packages such as service, exception, and main
 * so that each part of the system has a clear responsibility and is easier to manage.
 *
 * 2. Why did you separate your classes this way?
 * - I separated them to follow a layered structure where the calculator logic is 
 * in the service layer, the custom errors are in the exception layer, and the 
 * execution is in the main class. This makes the code cleaner and easier to 
 * maintain.
 * 
 * 3. How do packages improve encapsulation?
 * - Packages improve encapsulation by allowing me to use access modifiers properly. 
 * Because of this, I can limit which classes can access certain methods or fields.
 * 
 * 4. Where are your exceptions located?
 * - The exceptions are stored in the exception package so they are centralized
 * and can be reused across different parts of the program.
 *
 * 5. Why did you choose Gradle?
 * - I chose Gradle because it is simple to configure, faster to build, and works 
 * well for managing dependencies and running the project in a structured way.
 *
 */