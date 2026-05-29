package com.learning.appl.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

// happens when the text is blank or invalid
public record UserRequest(
        @NotBlank(message = "Name is required")
        String username,

        @NotBlank(message = "Password is required")
        String password,

        @Email(message = "Invalid Email")
        String email
) {}
