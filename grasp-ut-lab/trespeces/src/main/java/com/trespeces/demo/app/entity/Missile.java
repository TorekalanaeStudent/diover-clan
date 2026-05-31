package com.trespeces.demo.app.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

/*
 * RETROSPECT:
 * 1. Hardest GRASP Principle: Low Coupling - ensuring the Service depends only
 *    on the LaunchMethod interface and not on concrete implementations (AirLaunch, SeaLaunch).
 * 2. Design Mistake Fixed: Initially placed calculateTotal() inside the Service,
 *    but moved it to the Missile entity since it owns the data (Information Expert).
 */

// GRASP: Information Expert - Missile owns its data and calculates its own total
@Entity
@Table(name = "missiles")
@Getter
@Setter
@NoArgsConstructor
public class Missile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String type;
    private double price;
    private int quantity;
    private String status;     // PENDING, LAUNCHED, CANCELLED, DESTROYED

    public Missile(String name, String type, double price, int quantity) {
        this.name = name;
        this.type = type;
        this.price = price;
        this.quantity = quantity;
        this.status = "PENDING";
    }

    // GRASP: Information Expert - Missile calculates its own total cost
    public double calculateTotal() {
        return price * quantity;
    }
}