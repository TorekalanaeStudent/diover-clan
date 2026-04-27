package com.calculator.obedoza.exception;

/**
 * @author Trespeces, Guillermo II O.
 * @willj067
 */

// checked exception - must be declared or handled
public class DivisionByZeroException extends Exception {

    public DivisionByZeroException() {
        super("Cannot divide by zero.");
    }

    public DivisionByZeroException(String message) {
        super(message);
    }
}