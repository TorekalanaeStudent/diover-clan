package com.grasp.jagunap.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String customerName;
    private String status;

    // GRASP: Creator — Order creates and owns its OrderItems
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "order_id")
    private List<OrderItem> items = new ArrayList<>();

    // GRASP: Information Expert — Order calculates its own total
    //        because Order owns the items list
    public double calculateTotal() {
        return items.stream()
                .mapToDouble(OrderItem::getSubtotal)
                .sum();
    }

    // GRASP: Creator — Order creates OrderItem instances
    public void addItem(String productName, double price, int quantity) {
        this.items.add(new OrderItem(productName, price, quantity));
    }

    public Order() {}

    public Order(String customerName) {
        this.customerName = customerName;
        this.status = "PENDING";
    }

    public Long getId() { return id; }
    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public List<OrderItem> getItems() { return items; }
    public void setItems(List<OrderItem> items) { this.items = items; }
}