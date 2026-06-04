package com.grasp.jagunap.exception;

// GRASP: Protected Variations - custom exception shields callers from internal errors
public class OrderNotFoundException extends RuntimeException {
    public OrderNotFoundException(Long id) {
        super("Order not found with id: " + id);
    }
}
