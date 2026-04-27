package com.calculator.obedoza.main;

import com.calculator.obedoza.exception.DivisionByZeroException;
import com.calculator.obedoza.exception.InvalidInputException;
import com.calculator.obedoza.exception.NegativeNumberException;
import com.calculator.obedoza.service.AbstractCalculator;
import com.calculator.obedoza.service.BasicCalculator;

/**
1. How did you organize your packages?
Answer: I organized them in terms of the responsibility and functionality of each class. 
I separated them interms of excpetion, main and service so that classes are grouped together.  

2. Why did you separate your classes this way?
Answer: I separated them so that they would be distinct in terms of their functions and responsiblity
within the code

3. How do packages improve encapsulation?
Answer: The limit the access that others can have to your classes and methods. It hides the implimentations
and prevents unnecessary access. 

4. Where are your exceptions located?
Answer: The exceptionsa are located within com.calculator.obedoza.exception 

5. Why did you choose Maven or Gradle?
Answer: I chose grade because from the demonstration I can conclude that it is much faster
and more flexible Gradle provides better performance during build time and allows easier 
customization of project configurations.

 */

public class CalculatorDemo_obedoza {
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
