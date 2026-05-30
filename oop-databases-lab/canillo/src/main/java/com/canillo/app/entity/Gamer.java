package com.canillo.app.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "gamers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Gamer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Phone Number is required")
    private String phoneNumber;

    @Email(message = "Must be a valid email")
    @NotBlank(message = "Name is required")
    private String email;

    private Boolean isProGamer;

    @NotBlank(message = "Rank is required")
    private String rank;

}
