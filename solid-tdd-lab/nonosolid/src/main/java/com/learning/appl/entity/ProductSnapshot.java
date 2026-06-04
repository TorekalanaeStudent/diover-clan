package com.learning.appl.entity;

/**
 * ProductSnapshot — OOP Best Practice: Immutability
 * A read-only snapshot of a product at a point in time.
 * Java record: all fields final, no setters, auto equals/hashCode/toString.
 * Used for audit logs, price history, and safe data sharing.
 */
public record ProductSnapshot(
        Long id,
        String name,
        String category,
        Double price,
        int stockQuantity
) {
    /**
     * Factory method: create a snapshot from a live Product entity.
     */
    public static ProductSnapshot from(Product product) {
        return new ProductSnapshot(
                product.getId(),
                product.getName(),
                product.getCategory(),
                product.getPrice(),
                product.getStockQuantity()
        );
    }
}
