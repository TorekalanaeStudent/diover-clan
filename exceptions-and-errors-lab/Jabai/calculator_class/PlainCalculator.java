package calculator_class;

/**
 * Basic Calculator
 * Onte, Vince Gian
 * Malig, Rich Matthew
 */

public class PlainCalculator {

    private String name;
    private int lastResult;

    public PlainCalculator (String name) {
        this.name = name;
        this lastResult = 0;
    }
    
    //Method Overloading 
    public int add (int a, int b) {
        lastResult = a + b;
        return lastResult;
    }
    public double add (double a, double b) {
        lastResult = (int) (a+b);
        return a + b;
    }
    public int subtract (int a, int b) {
        lastResult = a - b;
        return lastResult;
    }
    public int multiply (int a, int b) {
        lastResult = a * b;
        return lastResult;
    }
    public int divide (int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero.")
        }
        lastResult = a / b;
        return lastResult;
    }

    //Another exception
    public boolean validateInput(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("Negative numbers are not allowed.");
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