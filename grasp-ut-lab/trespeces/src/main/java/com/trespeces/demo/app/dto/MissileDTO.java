package com.trespeces.demo.app.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

// GRASP: Pure Fabrication - DTO exists only for clean data transfer
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MissileDTO {
    private Long id;
    private String name;
    private String type;
    private double price;
    private int quantity;
    private String status;
    private double total;
}