package com.learning.appl.dto.responses;

// the infos the user put
public record UserResponse(
        Long id,
        String username,
        String email
        
) { }
