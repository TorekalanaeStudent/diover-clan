package com.calculator.nono.service;
/**
 * Calculator System Class
 * Nono, Mary Angeline B.
 */

import com.calculator.nono.exception.InvalidInputException;
import com.calculator.nono.exception.NegativeNumberException;

public class Calculator {

    // ✅ Addition (Method Overloading)
    public int add(int a, int b) {
        return a + b;
    }

    public double add(double a, double b) {
        return a + b;
    }

    // ✅ Subtraction
    public int subtract(int a, int b) {
        return a - b;
    }

    public double subtract(double a, double b) {
        return a - b;
    }

    // ✅ Multiplication
    public int multiply(int a, int b) {
        validateNegative(a, b);
        return a * b;
    }

    public double multiply(double a, double b) {
        validateNegative(a, b);
        return a * b;
    }

    // ✅ Division
    public int divide(int a, int b) throws InvalidInputException {
        if (b == 0) {
            throw new InvalidInputException("Division by zero is not allowed.");
        }
        return a / b;
    }

    public double divide(double a, double b) throws InvalidInputException {
        if (b == 0.0) {
            throw new InvalidInputException("Division by zero is not allowed.");
        }
        return a / b;
    }

    // ✅ Helper (package-private)
    void validateNegative(Number a, Number b) {
        if (a.doubleValue() < 0 || b.doubleValue() < 0) {
            throw new NegativeNumberException("Negative numbers are not allowed.");
        }
    }
}