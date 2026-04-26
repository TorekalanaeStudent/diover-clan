package com.calculator.trespeces.service;

/**
 * @author Obedoza, John Kyle B.
 * @KyleObedoza
 */

import com.calculator.trespeces.exception.DivisionByZeroException;

public abstract class AbstractCalculator {

    // Abstract methods 
    public abstract double addition(double a, double b);
    public abstract double subtraction(double a, double b);
    public abstract double multiplication(double a, double b);
    public abstract double division(double a, double b) throws DivisionByZeroException;

}