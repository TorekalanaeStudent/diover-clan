package com.calculator.ovejera.service;

import com.calculator.ovejera.exception.InvalidInputException_TeamJina;
import com.calculator.ovejera.exception.NegativeNumberException_TeamJina;

public class CalculatorClass_TeamJina {

    public double divide(double a, double b)
            throws InvalidInputException_TeamJina, NegativeNumberException_TeamJina {

        if (b == 0) {
            throw new InvalidInputException_TeamJina("Cannot divide by zero.");
        }

        if (a < 0 || b < 0) {
            throw new NegativeNumberException_TeamJina("Negative numbers are not allowed.");
        }

        return a / b;
    }
}