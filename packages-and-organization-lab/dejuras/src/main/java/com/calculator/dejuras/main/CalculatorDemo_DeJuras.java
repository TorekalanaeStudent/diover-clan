package com.calculator.dejuras.main;

import com.calculator.dejuras.service.AbstractCalculator;
import com.calculator.dejuras.service.Calculator;
import com.calculator.dejuras.service.CalculatorSystem;
import com.calculator.dejuras.exception.*;
/**
 * De Juras, Clint Norbert P.
 * @author @cdejuras
 */
public class CalculatorDemo_DeJuras {
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