package com.learning.appl.dto;

/**
 * ProductResponse — Data Transfer Object (DTO)
 * Returns only the data the client needs (not internal entity state).
 */
public class ProductResponse {

    private Long id;
    private String name;
    private String category;
    private Double price;
    private Double discountedPrice;
    private int stockQuantity;
    private String description;
    private boolean available;

    public ProductResponse() {}

    public ProductResponse(Long id, String name, String category, Double price,
                           Double discountedPrice, int stockQuantity,
                           String description, boolean available) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.discountedPrice = discountedPrice;
        this.stockQuantity = stockQuantity;
        this.description = description;
        this.available = available;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }

    public Double getDiscountedPrice() { return discountedPrice; }
    public void setDiscountedPrice(Double discountedPrice) { this.discountedPrice = discountedPrice; }

    public int getStockQuantity() { return stockQuantity; }
    public void setStockQuantity(int stockQuantity) { this.stockQuantity = stockQuantity; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public boolean isAvailable() { return available; }
    public void setAvailable(boolean available) { this.available = available; }
}
