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
}