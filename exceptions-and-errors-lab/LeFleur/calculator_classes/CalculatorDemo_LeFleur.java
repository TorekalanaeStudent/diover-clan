package calculator_class;

import implementations.Calculator;
import abstract_classes.AbstractCalculator;
import interfaces.CalculatorSystem;
import exceptions_lefleur.InvalidInputException;
import exceptions_lefleur.DivisionByZeroException;

/**
 * Group Members:
 * Arban, Jhave P.
 * De Juras, Clint Norbert P.
 * @author @jhavearban-ctrl @cdejuras
 *
 *  Q1: What exceptions did you create?
 *  InvalidInputException (checked), DivisionByZeroException (unchecked)
 *
 *  Q2: Which are checked vs unchecked?
 *  - InvalidInputException extends Exception → checked
 *  - DivisionByZeroException extends RuntimeException → unchecked
 *
 *  Q3: Where are exceptions thrown?
 *  - divide(int, int) throws InvalidInputException when b == 0
 *  - divide(double, double) throws DivisionByZeroException when b == 0
 *
 *  Q4: Where are they handled?
 *  - Handled here in the demo class using try-catch-finally
 *
 *  Q5: Where does propagation occur?
 *  - divide(int, int) propagates InvalidInputException up to the caller
 *  - divide(double, double) propagates DivisionByZeroException up to the caller
 *
 *  Q6: How did you apply OOP concepts?
 *  - Encapsulation: fields are private in Calculator, accessed via getters
 *  - Abstraction: AbstractCalculator defines structure, interface defines contract
 *  - Inheritance: Calculator extends AbstractCalculator
 *  - Polymorphism: methods overloaded for int and double
 */
public class CalculatorDemo_LeFleur {
    public static void main(String[] args) {

        // Default Constructor
        Calculator calc = new Calculator();

        System.out.println("==== " + calc.getCalculatorName().toUpperCase() + " ====");
        System.out.println();

        // Basic INT Operations
        System.out.println("==== BASIC INT OPERATIONS ====");
        calc.add(10, 5);
        calc.subtract(10, 5);
        calc.multiply(10, 5);

        System.out.println();

        // Basic DOUBLE Operations
        System.out.println("==== BASIC DOUBLE OPERATIONS ====");
        calc.add(10.5, 4.5);
        calc.subtract(10.5, 4.5);
        calc.multiply(10.5, 4.5);

        System.out.println();

        // Polymorphism via Abstract Class
        System.out.println("==== POLYMORPHISM VIA ABSTRACT CLASS ====");
        AbstractCalculator abstractCalc = calc;
        abstractCalc.add(20.0, 30.0);
        abstractCalc.subtract(50.0, 15.0);

        System.out.println();

        // Polymorphism via Interface
        System.out.println("==== POLYMORPHISM VIA INTERFACE ====");
        CalculatorSystem calcOps = calc;
        calcOps.add(100, 200);
        calcOps.subtract(100, 50);

        System.out.println();

        // Interface Default Method
        System.out.println("==== INTERFACE DEFAULT METHOD ====");
        calcOps.showOperation("Addition", calc.getLastResult());

        System.out.println();

        // Checked Exception
        System.out.println("==== CHECKED EXCEPTION: divide(int, int) ====");
        try {
            calc.divide(10, 2);
            calc.divide(10, 0);   // triggers InvalidInputException
        } catch (InvalidInputException e) {
            System.out.println("Caught checked exception: " + e.getMessage());
        } finally {
            System.out.println("INT division block executed.");
        }

        System.out.println();

        // Unchecked Exception
        System.out.println("==== UNCHECKED EXCEPTION: divide(double, double) ====");
        try {
            calc.divide(10.0, 2.0);
            calc.divide(10.0, 0.0);   // triggers DivisionByZeroException
        } catch (DivisionByZeroException e) {
            System.out.println("Caught unchecked exception: " + e.getMessage());
        } finally {
            System.out.println("DOUBLE division block executed.");
        }

        System.out.println();

        // Exception Propagation
        System.out.println("==== EXCEPTION PROPAGATION VIA INTERFACE ====");
        try {
            calcOps.divide(50, 0);
        } catch (InvalidInputException e) {
            System.out.println("Propagated exception caught: " + e.getMessage());
        } finally {
            System.out.println("Propagation block executed.");
        }
    }
}