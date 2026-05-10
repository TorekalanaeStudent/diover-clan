package com.calculator.ovejera.main;

import com.calculator.ovejera.service.CalculatorClass_TeamJina;
import com.calculator.ovejera.exception.InvalidInputException_TeamJina;
import com.calculator.ovejera.exception.NegativeNumberException_TeamJina;

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
 * A4: The exceptions are located in com.calculator.ovejera.exception.
 *
 * Q5: Why did you choose Maven or Gradle?
 * A5: I chose Gradle because it is faster, flexible, and uses a simpler DSL compared to XML.
 */


public class CalculatorDemo_TeamJina {

    public static void main(String[] args) {

        CalculatorClass_TeamJina calc = new CalculatorClass_TeamJina();

        System.out.println("========== MY CALCULATOR ==========\n");

        try {
            System.out.println("20 / 4 = " + calc.divide(20, 4));
            System.out.println("12.6 / 3.0 = " + calc.divide(12.6, 3.0));
        } catch (InvalidInputException_TeamJina | NegativeNumberException_TeamJina e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("10 / 0 = " + calc.divide(10, 0));
        } catch (InvalidInputException_TeamJina | NegativeNumberException_TeamJina e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            System.out.println("-10 / 2 = " + calc.divide(-10, 2));
        } catch (InvalidInputException_TeamJina | NegativeNumberException_TeamJina e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}