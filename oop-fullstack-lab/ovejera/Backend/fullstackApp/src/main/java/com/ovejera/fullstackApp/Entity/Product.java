package com.ovejera.fullstackApp.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table (name = "products")
public class Product {

    @Id
    @GeneratedValue
   private Long id;

    private String name;
    private String description;

    @NotNull(message = "Price cannot be null")
    private Double price;
    private Integer quantity;
}
