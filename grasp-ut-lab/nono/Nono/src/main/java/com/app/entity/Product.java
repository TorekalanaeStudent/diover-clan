package com.app.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * GRASP: Information Expert
 * ─────────────────────────
 * Product owns its own data, so it performs its own calculations.
 * Discount logic, price-with-tax, and stock checks live HERE —
 * not scattered in services.
 *
 * GRASP: Creator
 * ──────────────
 * Product creates ProductReview objects (see addReview) because it has
 * the data needed to initialise them.
 */
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name must not be blank")
    private String name;

    @NotBlank(message = "Category must not be blank")
    private String category;

    @NotNull(message = "Price is required")
    @Positive(message = "Price must be positive")
    private BigDecimal price;

    @NotNull(message = "Stock quantity is required")
    private Integer stockQuantity;

    private String description;

    // ── Constructors ─────────────────────────────────────────────────────────

    public Product() {}

    public Product(String name, String category, BigDecimal price, int stockQuantity) {
        this.name          = name;
        this.category      = category;
        this.price         = price;
        this.stockQuantity = stockQuantity;
    }

    // ── GRASP: Information Expert — business logic belongs to the data owner ──

    /**
     * Returns the final price after applying a percentage discount.
     * GRASP: Information Expert – Product knows its own price.
     */
    public BigDecimal calculateDiscountedPrice(double discountPercent) {
        if (discountPercent < 0 || discountPercent > 100) {
            throw new IllegalArgumentException("Discount must be between 0 and 100");
        }
        BigDecimal factor = BigDecimal.valueOf(1 - discountPercent / 100.0);
        return price.multiply(factor).setScale(2, RoundingMode.HALF_UP);
    }

    /**
     * Returns the price with VAT applied.
     * GRASP: Information Expert – Product knows its own price.
     */
    public BigDecimal calculatePriceWithTax(double taxRate) {
        if (taxRate < 0) {
            throw new IllegalArgumentException("Tax rate cannot be negative");
        }
        BigDecimal factor = BigDecimal.valueOf(1 + taxRate);
        return price.multiply(factor).setScale(2, RoundingMode.HALF_UP);
    }

    /**
     * Checks whether the requested quantity can be fulfilled.
     * GRASP: Information Expert – Product knows its own stock.
     */
    public boolean isAvailable(int requestedQuantity) {
        return stockQuantity >= requestedQuantity;
    }

    /**
     * Reduces stock after a sale.
     * GRASP: Information Expert – Product manages its own inventory.
     */
    public void deductStock(int quantity) {
        if (!isAvailable(quantity)) {
            throw new IllegalStateException(
                "Insufficient stock. Available: " + stockQuantity + ", Requested: " + quantity);
        }
        this.stockQuantity -= quantity;
    }

    // ── Getters & Setters ────────────────────────────────────────────────────

    public Long getId()                          { return id; }
    public void setId(Long id)                   { this.id = id; }

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
