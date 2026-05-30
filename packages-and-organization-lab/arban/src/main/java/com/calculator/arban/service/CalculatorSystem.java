package com.calculator.arban.service;

import com.calculator.arban.exception.InvalidInputException;

public interface CalculatorSystem {
    int add(int a, int b);
    int subtract(int a, int b);
    int multiply(int a, int b);
    int divide(int a, int b) throws InvalidInputException;

    default void showOperation(String operation, double result) {
        System.out.println("Operation: " + operation + " = " + result);
    }
}