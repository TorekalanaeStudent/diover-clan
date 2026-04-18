package App_Demo;

import app_model.BasicCalculator;
import app_exceptions.DivisionByZeroException;
import app_exceptions.InvalidInputException;
import app_exceptions.NegativeNumberException;

/**
 * @author Go, Sean Ethan G.
 * @SethPlaysBadly
 *
 *  Q1: What exceptions did you create?
 *    - DivisionByZeroException (checked)
 *    - InvalidInputException (unchecked)
 *    - NegativeNumberException (unchecked)
 *
 *  Q2: Which are checked vs unchecked?
 *    - Checked: DivisionByZeroException extends Exception
 *    - Unchecked: InvalidInputException and NegativeNumberException extend RuntimeException
 *
 *  Q3: Where are exceptions thrown?
 *    - DivisionByZeroException is thrown in BasicCalculator.division() when b == 0
 *    - InvalidInputException is thrown in BasicCalculator.validate() when value == 0
 *    - NegativeNumberException is thrown in BasicCalculator.validate() when value < 0
 *
 *  Q4: Where are they handled?
 *    - All exceptions are handled here in the demo via try-catch-finally blocks
 *
 *  Q5: Where does propagation occur?
 *    - Exceptions thrown in BasicCalculator propagate up to this demo class where they are caught
 *
 *  Q6: How did you apply OOP concepts?
 *    - Encapsulation: BasicCalculator encapsulates all calculator logic
 *    - Abstraction: AbstractCalculator defines the blueprint
 *    - Inheritance: BasicCalculator extends AbstractCalculator
 *    - Polymorphism: method overloading in addition() (int vs double)
 */

public class CalculatorDemo {
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
