package com.gedoria.app.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "buyers")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @NotBlank(message = "Item must have name.")
    private String name;

    @NotBlank(message = "Item must have description")
    private String description;

    @NotBlank(message = "Item must have location.")
    private String location;


    private boolean isAvailable = true;

    @NotNull(message = "Item must have listed price.")
    @Positive(message = "Item must have positive integer as price.")
    private double price;
}