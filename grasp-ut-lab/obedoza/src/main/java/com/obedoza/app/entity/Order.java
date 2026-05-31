package com.obedoza.app.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Entity
@Table(name = "orders")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String customerName;
    private String status; // PENDING, CONFIRMED, CANCELLED
    private LocalDateTime createdAt;

    // GRASP: Creator
    // Order contains OrderItems, so Order is responsible for creating them
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "order_id")
    private ArrayList<OrderItem> items = new ArrayList<>();

    // GRASP: Information Expert
    // Order owns the items list, so Order calculates its own total
    public double calculateTotal() {
        return items.stream().mapToDouble(OrderItem::getSubtotal).sum();
    }

    // GRASP: Creator — Order creates its own OrderItems
    public void addItem(String productName, int quantity, double unitPrice) {
        OrderItem item = new OrderItem(null, productName, quantity, unitPrice);
        this.items.add(item);
    }
}
