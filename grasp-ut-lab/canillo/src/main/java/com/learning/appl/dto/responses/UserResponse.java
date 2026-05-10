package com.learning.appl.dto.responses;

public record UserResponse(
        Long id,
        String username,
        String email
) { }
