package calculator_class;

/**
 * Basic Calculator
 * Onte, Vince Gian
 * Malig, Rich Matthew
 */

import exceptions.DivideByZeroException;
import exceptions.NegativeNumException;

public class PlainCalculator {

    private String name;
    private int lastResult;

    public PlainCalculator(String name) {
        this.name = name;
        this.lastResult = 0;
    }

    // Method Overloading
    public int add(int a, int b) {
        lastResult = a + b;
        return lastResult;
    }

    public double add(double a, double b) {
        lastResult = (int) (a + b);
        return a + b;
    }

    public int subtract(int a, int b) {
        lastResult = a - b;
        return lastResult;
    }

    public int multiply(int a, int b) {
        lastResult = a * b;
        return lastResult;
    }

    public int divide(int a, int b) throws DivideByZeroException {
        if (b == 0) {
            throw new DivideByZeroException("Cannot divide by zero.");
        }
        lastResult = a / b;
        return lastResult;
    }

    public boolean validateInput(int value) throws NegativeNumException {
        if (value < 0) {
            throw new NegativeNumException("Negative numbers are not allowed.");
        }
        return true;
    }

    public int getLastResult() {
        return lastResult;
    }

    public void clear() {
        lastResult = 0;
    }

    public String getName() {
        return name;
    }
}