package com.learning.appl.entity;

import com.learning.appl.dto.request.UserRequest;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder // Creational Pattern: Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User{
    // SOLID: SRP - Represents and manages user domain state
    // GRASP: Information Expert - Lets User handles theiw own data

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    private String email;

    // OOP: Encapsulation
    public void updateDetails(UserRequest req) {
        this.username = req.username();
        this.password = req.password();
        this.email = req.email();
    }

}