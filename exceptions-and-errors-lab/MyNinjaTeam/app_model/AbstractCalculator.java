package app_model;

/**
 * @author Obedoza, John Kyle B.
 * @KyleObedoza
 */

import app_exceptions.DivisionByZeroException;

public abstract class AbstractCalculator {

    // Abstract methods 
    public abstract double addition(double a, double b);
    public abstract double subtraction(double a, double b);
    public abstract double multiplication(double a, double b);
    public abstract double division(double a, double b) throws DivisionByZeroException;

}