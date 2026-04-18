package model;

/**
 * @author Obedoza, John Kyle B.
 * @KyleObedoza
 */

import app_exceptions.InvalidInputException;
import app_exceptions.NegativeNumberException;
import app_exceptions.DivisionByZeroException;


public class BasicCalculator extends AbstractCalculator {

    // Method overloading 
    public int addition(int a, int b) {
        return a + b;
    }

    @Override
    public double addition(double a, double b) {
        return a + b;
    }

    @Override
    public double subtraction(double a, double b) {
        return a - b;
    }

    @Override
    public double multiplication(double a, double b) {
        return a * b;
    }

    @Override
    public double division(double a, double b) throws InvalidInputException, NegativeNumberException, ArithmeticException {
        if (b == 0) {
            throw new DivisionByZeroException("Cannot divide by zero!");
        }
        return a/b;
    }

    // Custom Validation method 
    public void validate(double value) throws InvalidInputException, NegativeNumberException {
        if (value == 0) {
            throw new InvalidInputException("Zero is not allowed!");
        }
        if (value < 0) {
            throw new NegativeNumberException("Negative numbers are not allowed!");
        }
    }
    
}