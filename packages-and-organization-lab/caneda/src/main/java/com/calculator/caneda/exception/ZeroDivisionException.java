package com.calculator.caneda.exception;

public class ZeroDivisionException extends Exception {
    // checked exception, will need to handle division by zero
    public ZeroDivisionException(String message) {
        super(message);
    }
}