package com.learning.appl.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import java.util.List;

/**
 * GRASP: Pure Fabrication / Low Coupling
 */
public class OrderRequest {

    @NotBlank(message = "Customer name is required")
    private String customerName;

    @NotEmpty(message = "Order must have at least one item")
    @Valid
    private List<OrderItemRequest> items;

    @NotBlank(message = "Payment method is required")
    private String paymentMethod; // "CREDIT_CARD" | "PAYPAL" | "BANK_TRANSFER"

    // ── Nested DTO ────────────────────────────────────────────────────────────
    public static class OrderItemRequest {
        @NotBlank
        private String productName;

        @Min(1)
        private int quantity;

        @Min(0)
        private double unitPrice;

        public String getProductName() { return productName; }
        public int    getQuantity()    { return quantity; }
        public double getUnitPrice()   { return unitPrice; }

        public void setProductName(String productName) { this.productName = productName; }
        public void setQuantity(int quantity)          { this.quantity = quantity; }
        public void setUnitPrice(double unitPrice)     { this.unitPrice = unitPrice; }
    }

    // ── Getters / setters ─────────────────────────────────────────────────────
    public String               getCustomerName() { return customerName; }
    public List<OrderItemRequest> getItems()       { return items; }
    public String               getPaymentMethod() { return paymentMethod; }

    public void setCustomerName(String customerName)   { this.customerName = customerName; }
    public void setItems(List<OrderItemRequest> items) { this.items = items; }
    public void setPaymentMethod(String paymentMethod) { this.paymentMethod = paymentMethod; }
}