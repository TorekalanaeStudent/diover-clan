package com.calculator.malig.main;

/*
Code-Based Analysis

1. How did you organize your packages?
I organized my project using a layered structure:
- model: contains data classes (e.g., Calculation)
- service: contains the business logic (e.g., CalculatorService)
- exception: contains custom exceptions
- app: contains the main class to run the program

2. Why did you separate your classes this way?
I separated the classes to follow clean code principles. Each package has a single responsibility:
- model handles data
- service handles operations
- exception handles errors
- app handles execution
This makes the code easier to read, maintain, and expand.

3. How do packages improve encapsulation?
Packages group related classes together and limit access using access modifiers (private, protected, public).
This prevents other parts of the program from directly accessing internal logic and protects the data.

4. Where are your exceptions located?
All custom exceptions are placed inside the "exception" package:
com.calculator.malig.exception

5. Why did you choose Gradle?
I chose Gradle because it is fast, flexible, and easy to configure.
It allows automatic building, dependency management, and project structure handling.
It is also widely used in modern Java development.
*/

import com.calculator.malig.service.PlainCalculator;
import com.calculator.malig.exception.*;



public class CalculatorDemo_Malig {

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