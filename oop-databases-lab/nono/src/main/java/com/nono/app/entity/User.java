package com.nono.app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
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
@Table(name = "USERS")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Phone Number is required")
    private String phoneNumber;

    @Email(message = "Must be a valid email")
    @NotBlank(message = "Email is required")
    private String email;

    private Boolean isRegular;

    @NotBlank(message = "Rank is required")
    private String rank;

}
