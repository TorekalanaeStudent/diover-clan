package com.app.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private double baseSalary;

    private double bonus;

    private double hourlyRate;

    private int hoursWorked;

    // GRASP: Information Expert
    public double calculateTotalSalary() {
        return baseSalary + bonus;
    }
}