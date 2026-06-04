package com.learning.appl.exceptions;

/**
 * ProductNotFoundException — GRASP: Protected Variations
 * Shields callers from raw JPA/database exceptions.
 */
public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(Long id) {
        super("Product not found with id: " + id);
    }
    public ProductNotFoundException(String message) {
        super(message);
    }
}
