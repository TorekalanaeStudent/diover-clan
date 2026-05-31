package com.grasp.cardeno.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;

// GRASP: Pure Fabrication - Created solely to support data exchange between layers.
// GRASP: Low Coupling - Decouples external layers from your internal entity structure.
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class TaskDTO {
    private String title;
    private LocalDate dueDate;
}