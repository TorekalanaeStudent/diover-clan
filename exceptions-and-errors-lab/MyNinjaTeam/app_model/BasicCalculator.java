package model;


public class BasicCalculator extends AbstractCalculator {

    // Method overloading 
    public int add(int a, int b) {
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
    public double division(double a, double b) throws ArithmeticException {
        if (b == 0 ) {
            throw new ArithmeticException("Cannot be divided by zero!");
        }
        return a/b;
    }

    // Custom Validation method 
    public void validate(double value) throws InvalidInputExceptions {
        if (value == 0) {
            throw new InvalidInputExceptions("Zero is not allowed!");
        } 
        if (value <0) {
            throw new NegativeNumberException("Negative numbers are not allowed!");
        }
    }

}