package com.gedoria.app.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * What changed from previous lab?
 * It went from basic OOP code with classes to spring boot apps with entities and databases.
 *
 * Why database is better?
 * It keeps data organized and easier to manage.
 *
 * How JPA helped?
 * It helped to provide built-in CRUD operations through repos.
 *
 * What changed when switching DB?
 * Switching databases changed settings but code stayed the same
 */

@Entity
@Table(name = "buyers")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Buyer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @NotBlank(message = "User must have name.")
    private String name;

    @NotBlank(message = "User must have phone number.")
    private String phoneNumber;

    @Email(message = "Email must be valid.")
    @NotBlank(message = "User must have email.")
    private String email;


    private boolean isTrusted;

    private double wallet;
}
