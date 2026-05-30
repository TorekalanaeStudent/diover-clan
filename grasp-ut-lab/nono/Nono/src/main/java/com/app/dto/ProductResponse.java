package com.app.dto;

import java.math.BigDecimal;

/**
 * BONUS: DTO pattern
 * What the API returns — keeps entity internals hidden.
 */
public class ProductResponse {

    private Long       id;
    private String     name;
    private String     category;
    private BigDecimal price;
    private Integer    stockQuantity;
    private String     description;
    private boolean    available;   // derived field: stockQuantity > 0

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

    public boolean isAvailable()                 { return available; }
    public void setAvailable(boolean available)  { this.available = available; }
}
