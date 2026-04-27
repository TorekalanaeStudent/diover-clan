package com.calculator.navarro.service;
/**
 * Calculator System Class
 * Navarro, Vince Justine
 * @author@StillLizard0106
 */

import com.calculator.navarro.exception.*; // no need to do it 1 by 1 since it's all i need in exceptions

public class SimpleCalculator {

    private final String name;
    private int operationCount;

    public SimpleCalculator() {
        this.name = "Simple Calculator";
        this.operationCount = 0;
    }

    public int add(int a, int b) {
        operationCount++;
        return a + b;
    }

    public double add(double a, double b) {
        operationCount++;
        return a + b;
    }

    public int subtract(int a, int b) {
        operationCount++;
        return a - b;
    }

    public double subtract(double a, double b) {
        operationCount++;
        return a - b;
    }
    public int multiply(int a, int b) {
        if(a < 0 || b < 0){
            throw new NegativeNumberException("Negative number is NOT allowed.");
        }
        operationCount++;
        return a * b;
    }

    public double multiply(double a, double b) {
        operationCount++;
        return a * b;
    }

    public int divide(int a, int b) throws ZeroDivisionException{
        if (b == 0)
            throw new ZeroDivisionException("Cannot divide number by zero");
        operationCount++;
        return a / b;
    }

    public double divide(double a, double b) throws ZeroDivisionException{
        if (b == 0)
            throw new ZeroDivisionException("Cannot divide double by zero.");
        operationCount++;
        return a / b;
    }

    public String getName()          { return name; }
    public int    getOperationCount() { return operationCount; }
}