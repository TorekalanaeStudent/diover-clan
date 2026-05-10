package calculator_demo;

/**
 * Calculator Demo
 * Onte, Vince Gian
 * Malig, Rich Matthew
 * 
 * ANALYSIS
 * Q1: What exceptions did you create?
 * - We created two custom exceptions: DivideByZeroException and NegativeNumException.
 * 
 * Q2: Which are checked vs unchecked?
 * - DivideByZeroException is a checked exception because it extends Exception.
 * - NegativeNumException is also a checked exception because it extends Exception.
 * 
 * Q3: Where are exceptions thrown?
 * - DivideByZeroException is thrown in the divide() method when the divisor is zero.
 * - NegativeNumException is thrown in the validateInput() method when a negative number is provided.
 * 
 * Q4: Where are they handled?
 * - The exceptions are handled in the demo class using try-catch blocks.
 * 
 * Q5: Where does propagation occur?
 * - The propagation was shown when the exceptions are thrown in the calculator class and passed to the calling method
 *  in the demo class using the "throws" keyword.
 * 
 * Q6: How did you apply OOP concepts?
 * - Encapsulation: Private fields with public getters and methods.
 * - Abstraction: Methods hide the internal logic of calculations.
 * - Polymorphism: Method overloading in the add() method (int and double versions).
 * - Inheritance: Custom exceptions inherit from the Exception class.
 */

import calculator_class.PlainCalculator;
import exceptions.DivideByZeroException;
import exceptions.NegativeNumException;


public class PlainCalculatorDemo_MaligOnte {

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