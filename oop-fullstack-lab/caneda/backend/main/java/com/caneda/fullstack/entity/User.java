package com.caneda.fullstack.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data // generates getters, setters, toString, equals, hashCode
@Entity // JPA entity maps to a database table
@Table(name = "users") // Name of the table in PostgreSQL
public class User {

    @Id // main
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment ID
    private Long id;

    // User's name
    private String name;

    // User's email
    private String email;

    // User's role
    private String role;
}
