package com.jagunap.springboot.exception;

// Custom exception for when a resource is not found
// Separation of concerns: handles only exception logic
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message) {
        super(message);
    }
}