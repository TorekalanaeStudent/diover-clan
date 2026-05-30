package com.grasp.jagunap.exception;

// GRASP: Protected Variations — custom exception shields callers
//        from changes in how "not found" errors are reported
public class OrderNotFoundException extends RuntimeException {

    public OrderNotFoundException(Long id) {
        super("Order not found with ID: " + id);
    }
}