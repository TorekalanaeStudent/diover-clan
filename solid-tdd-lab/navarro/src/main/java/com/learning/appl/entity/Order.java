package com.learning.appl.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * GRASP: Information Expert - Order owns its items and calculates the total.
 *
 * GRASP: Creator - Order creates OrderItem instances via addItem().
 */
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String customerName;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private OrderStatus status;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    // Composition Over Inheritance: Order has OrderItems; items do not inherit from Order.
    // SOLID: SRP - Order keeps order state and total calculation only.
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItem> items = new ArrayList<>();

    protected Order() {
    }

    public Order(String customerName) {
        this.customerName = customerName;
        this.status = OrderStatus.PENDING;
        this.createdAt = LocalDateTime.now();
    }

    public OrderItem addItem(String productName, int quantity, double unitPrice) {
        OrderItem item = new OrderItem(productName, quantity, unitPrice);
        item.setOrder(this);
        items.add(item);
        return item;
    }

    public double calculateTotal() {
        return items.stream()
                .mapToDouble(OrderItem::subtotal)
                .sum();
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public Long getId() {
        return id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    // OOP: Immutability boundary - callers can read items but cannot mutate the collection.
    public List<OrderItem> getItems() {
        return Collections.unmodifiableList(items);
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public void setCustomerName(String name) {
        this.customerName = name;
    }
}
