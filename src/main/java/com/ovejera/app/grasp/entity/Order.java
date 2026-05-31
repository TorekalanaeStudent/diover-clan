package com.ovejera.app.grasp.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL)
    private List<OrderItem> items = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }

    // GRASP: Information Expert
    public double calculateTotal() {
        return items.stream()
                .mapToDouble(OrderItem::calculateSubtotal)
                .sum();
    }

    // GRASP: Creator
    public void addItem(OrderItem item) {
        items.add(item);
    }
}