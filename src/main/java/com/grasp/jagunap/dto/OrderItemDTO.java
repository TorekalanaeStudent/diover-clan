package com.grasp.jagunap.dto;

// GRASP: Pure Fabrication - DTO for transferring OrderItem data
public class OrderItemDTO {
    private Long id;
    private String productName;
    private double price;
    private int quantity;
    private double subtotal;

    public OrderItemDTO() {}

    public OrderItemDTO(Long id, String productName, double price, int quantity) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.subtotal = price * quantity;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public double getSubtotal() { return subtotal; }
    public void setSubtotal(double subtotal) { this.subtotal = subtotal; }
}
