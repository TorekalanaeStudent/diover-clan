package com.app.exception;

/**
 * BONUS: Custom exception handling
 * Thrown when a product cannot be found by ID.
 */
public class ProductNotFoundException extends RuntimeException {

    public ProductNotFoundException(Long id) {
        super("Product not found with id: " + id);
    }
}
