package com.navarro.springboot.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class Product {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Double price;
    private String category;
    private Integer stock;

    // Getters & Setters
    public Long getId() { return id; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public Double getPrice() { return price; }
    public String getCategory() { return category; }
    public Integer getStock() { return stock; }
    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setDescription(String d) { this.description = d; }
    public void setPrice(Double price) { this.price = price; }
    public void setCategory(String c) { this.category = c; }
    public void setStock(Integer stock) { this.stock = stock; }
}