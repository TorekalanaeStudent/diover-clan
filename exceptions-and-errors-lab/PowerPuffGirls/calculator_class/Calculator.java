package calculator_class;
 
import exceptions.InvalidInputException;
import exceptions.NegativeNumberException;
 
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
    public int multiply(int a, int b) throws NegativeNumberException {
        validateNegative(a, b);
        return a * b;
    }
 
    public double multiply(double a, double b) throws NegativeNumberException {
        validateNegative(a, b);
        return a * b;
    }
 
    // ✅ Division with propagation
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
 
    // ✅ Helper method (Exception propagation)
    protected void validateNegative(Number a, Number b) {
        if (a.doubleValue() < 0 || b.doubleValue() < 0) {
            throw new NegativeNumberException("Negative numbers are not allowed.");
        }
    }
}