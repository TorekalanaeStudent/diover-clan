package com.caneda.springboot.exception;

// GRASP: Protected Variations - isolates how insufficient balance is handled
public class InsufficientBalanceException extends RuntimeException {
    public InsufficientBalanceException(float amount) {
        super("Insufficient balance for amount: " + amount);
    }
}