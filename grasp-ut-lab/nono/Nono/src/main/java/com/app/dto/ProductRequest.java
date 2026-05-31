package com.app.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

/**
 * BONUS: DTO pattern
 * Decouples the HTTP contract from the JPA entity.
 * Clients send this; we never expose the raw entity directly.
 */
public class ProductRequest {

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Category is required")
    private String category;

    @NotNull(message = "Price is required")
    @Positive(message = "Price must be positive")
    private BigDecimal price;

    @NotNull(message = "Stock quantity is required")
    private Integer stockQuantity;

    private String description;

    // ── Getters & Setters ────────────────────────────────────────────────────

    public String getName()                      { return name; }
    public void setName(String name)             { this.name = name; }

    public String getCategory()                  { return category; }
    public void setCategory(String category)     { this.category = category; }

    public BigDecimal getPrice()                 { return price; }
    public void setPrice(BigDecimal price)       { this.price = price; }

    public Integer getStockQuantity()            { return stockQuantity; }
    public void setStockQuantity(Integer qty)    { this.stockQuantity = qty; }

    public String getDescription()               { return description; }
    public void setDescription(String desc)      { this.description = desc; }
}
