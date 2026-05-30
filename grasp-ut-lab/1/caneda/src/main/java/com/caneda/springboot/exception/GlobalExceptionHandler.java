package com.caneda.springboot.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// GRASP: Protected Variations - centralizes all error handling in one place
// if error response format changes, only this class needs to change
@ControllerAdvice
public class GlobalExceptionHandler {

    // handles user not found
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<String> handleUserNotFound(UserNotFoundException e) {
        return ResponseEntity.status(404).body(e.getMessage());
    }

    // handles insufficient balance
    @ExceptionHandler(InsufficientBalanceException.class)
    public ResponseEntity<String> handleInsufficientBalance(InsufficientBalanceException e) {
        return ResponseEntity.status(400).body(e.getMessage());
    }

    // handles invalid arguments like negative IDs
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgument(IllegalArgumentException e) {
        return ResponseEntity.status(400).body(e.getMessage());
    }
}