package com.calculator.dejuras.main;

import com.calculator.dejuras.service.AbstractCalculator;
import com.calculator.dejuras.service.Calculator;
import com.calculator.dejuras.service.CalculatorSystem;
import com.calculator.dejuras.exception.*;
/**
 * De Juras, Clint Norbert P.
 * @author @cdejuras
 * // Code-Based Analysis
 * Q1: How did you organize your packages?
 * A1: I structured my project into multiple folders to replicate how real-world applications are organized.
 * 
 * Q2: Why did you separate your classes this way?
 * A2: I wanted to better understand how real-world applications are designed and organized for clarity and maintainability.
 * 
 * Q3: How do packages enhance encapsulation?
 * A3: Packages enhance encapsulation by assigning each package a specific responsibility, preventing one package from handling everything.
 * 
 * Q4: Where are your exceptions located?
 * A4: My exception classes are stored in the com.calculator.dejuras.exceptions package.
 * 
 * Q5: Why did you choose Maven or Gradle?
 * A5: I selected Gradle because it’s faster and I prefer its DSL-based configuration over XML.
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