package com.calculator.gedoria.service;

import com.calculator.gedoria.exception.*;

//Gedoria, Rajan Kurt O.
//@author@rajangedoria-ctrl

public class SimpleCalculator {
    // private attributes
    private final String name;
    private int operationCount;

    // default 
    public SimpleCalculator() {
        this.name = "Calculator";
        this.operationCount = 0;
    }

    // addition 
    public int add(int a, int b) {
        operationCount++;
        return a + b;
    }

    public double add(double a, double b) {
        operationCount++;
        return a + b;
    }
    // subtraction
    public int subtract(int a, int b) {
        operationCount++;
        return a - b;
    }
    public double subtract(double a, double b) {
        operationCount++;
        return a - b;
    }
    // multiplication exception
    public int multiply(int a, int b) throws NegativeNumberException {
        if (a < 0 || b < 0) { // throw triggers exception
            throw new NegativeNumberException("Negative Numbers are INVALID!");
        }
        operationCount++;
        return a * b;
    }

    public double multiply(double a, double b) throws NegativeNumberException {
        if (a < 0 || b < 0) {
            throw new NegativeNumberException("Negative Numbers are INVALID!");
        }
        operationCount++;
        return a * b;
    }
    // division exception
    public int divide(int a, int b) throws ZeroDivisionException {
        if (b == 0) { // throw triggers exception
            throw new ZeroDivisionException("Numbers cannot be divided by Zero!");
        }
        operationCount++;
        return a / b;
    }

    public double divide(double a, double b) throws ZeroDivisionException {
        if (b == 0) {
            throw new ZeroDivisionException("Numbers cannot be divided by Zero!");
        }
        operationCount++;
        return a / b;
    }

    public String getName() {return name;}
    public int getOperationCount() {return operationCount;}


    

}