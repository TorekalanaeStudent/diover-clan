package com.nono.app.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* Author Mary Angeline B. Nono
* 
* 1.What changed from previous lab?
* -I moved from simple file handling or basic code to working with real databases. I learned how to connect our Spring Boot application to store and retrieve data properly, instead of just using variables or temporary memory.
* 
* 2. Why database is better?
* - Data stays forever: Data is saved permanently even if I close the program.
* - Organized: Information is stored in neat tables with rows and columns, making it easy to find.
* - Safe & Secure: I can control who accesses the data and prevent mistakes.
* - Handles large amounts: It can store thousands or millions of records easily without slowing down.
*
* 3.How JPA helped?
*  -JPA (Java Persistence API) made our work much easier. Instead of writing long and complicated SQL queries manually, I just used Java code and annotations. It automatically created tables, inserted data, and handled connections for us. It saved a lot of time and reduced errors.
*
* 4.What changed when switching DB?
* -When I switched from H2 to PostgreSQL:
* -I had to change the URL, username, and password in  application.properties .
*- I added the correct PostgreSQL Driver dependency.
*- The way I write code stayed almost the same because JPA works with many databases. Only the configuration part changed.
**/

@Entity
@Table(name = "Product")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    public static @NotNull(message = "Price is required")
    @Positive(message = "Price must be positive") Double getPrice;
    public static @NotBlank(message = "Category is required") String getCategory;
    public static String getDescription;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Product name is required")
    private String name;
    private String description;

    @NotNull(message = "Price is required")
    @Positive(message = "Price must be positive")
    private Double price;

    @NotBlank(message = "Category is required")
    private String category;

    private Boolean isAvailable = true;
}
