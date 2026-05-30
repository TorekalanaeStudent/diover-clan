package com.app.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class EmployeeResponseDTO {

    // SOLID: Immutable DTO
    private final Long id;
    private final String name;
    private final double totalSalary;
}