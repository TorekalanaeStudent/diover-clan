package com.learning.appl.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

/**
 * GRASP: Information Expert
 * OrderItem owns its own price/quantity data
 *
 * Owner: Creator
 * OrderItem is created by Order (via Order.addItem), since Order aggregates items.
 */
@Entity
@Table(name = "order_items")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String productName;

    @Min(1)
    @Column(nullable = false)
    private int quantity;

    @Min(0)
    @Column(nullable = false)
    private double unitPrice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    protected OrderItem() {}

    // GRASP: Creator — package-private constructor so only Order can create items
    OrderItem(String productName, int quantity, double unitPrice) {
        this.productName = productName;
        this.quantity    = quantity;
        this.unitPrice   = unitPrice;
    }

    // GRASP: Information Expert — subtotal lives where the data lives
    public double subtotal() {
        return quantity * unitPrice;
    }

    // ── Getters ──────────────────────────────────────────────────────────────

    public Long getId()            { return id; }
    public String getProductName() { return productName; }
    public int getQuantity()       { return quantity; }
    public double getUnitPrice()   { return unitPrice; }
    public Order getOrder()        { return order; }

    // ── Package-private setter used by Order ──────────────────────────────────
    void setOrder(Order order) { this.order = order; }
}
