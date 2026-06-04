package com.learning.appl.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * Product — GRASP: Information Expert
 * Knows its own data and answers questions about itself (isAvailable, hasDiscount).
 * OOP: Encapsulation — all fields private, accessed through getters/setters.
 */
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Category is required")
    private String category;

    @NotNull(message = "Price is required")
    @Min(value = 0, message = "Price must be non-negative")
    private Double price;

    @Min(value = 0, message = "Stock must be non-negative")
    private int stockQuantity;

    private String description;

    // GRASP: Information Expert — the entity knows if it is available
    public boolean isAvailable() {
        return stockQuantity > 0;
    }

    // GRASP: Information Expert — the entity knows if it qualifies for a discount
    public boolean hasDiscount() {
        return price != null && price > 500.0;
    }

    // ─── Constructors ────────────────────────────────────────────────────────────
    public Product() {}

    public Product(String name, String category, Double price, int stockQuantity, String description) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.description = description;
    }

    // ─── Getters & Setters ───────────────────────────────────────────────────────
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }

    public int getStockQuantity() { return stockQuantity; }
    public void setStockQuantity(int stockQuantity) { this.stockQuantity = stockQuantity; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}
