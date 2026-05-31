package com.grasp.cardeno.validation;

import com.grasp.cardeno.dto.TaskDTO;
import org.springframework.stereotype.Component;

@Component
public class TaskValidator {
    // SOLID: SRP - Handles only validation logic, keeping the Service clean.
    public void validate(TaskDTO dto) {
        if (dto == null) throw new IllegalArgumentException("Task cannot be null");
        if (dto.getTitle() == null || dto.getTitle().trim().isEmpty()) {
            throw new IllegalArgumentException("Task title is required");
        }
    }
}


