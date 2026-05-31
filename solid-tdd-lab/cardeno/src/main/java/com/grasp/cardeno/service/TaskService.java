package com.grasp.cardeno.service;

import com.grasp.cardeno.dto.TaskDTO;
import com.grasp.cardeno.entity.Task;
import com.grasp.cardeno.repository.TaskRepository;
import com.grasp.cardeno.util.NotificationStrategy;
import com.grasp.cardeno.validation.TaskValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

// GRASP: Pure Fabrication - Service coordinates tasks and separates business logic from entities
@Service
@RequiredArgsConstructor
public class TaskService {

    // DIP: Depends on Abstraction (NotificationStrategy) instead of concrete classes
    // GRASP: Low Coupling - Service is not aware of how notifications are sent
    private final TaskRepository repo;
    private final List<NotificationStrategy> notifiers;
    private final TaskValidator validator;

    // SOLID: SRP - Service is now only responsible for orchestration
    public Task createTask(TaskDTO dto) {

        // DRY: Validation logic is reused via TaskValidator
        // SOLID: SRP - Delegation of validation to a specialized component
        validator.validate(dto);

        // GRASP: Creator - Service is responsible for instantiating the Task entity
        Task task = new Task(null, dto.getTitle(), dto.getDueDate(), false);
        Task savedTask = repo.save(task);

        // GRASP: Polymorphism - Executes different notification behaviors via the same interface
        // SOLID: OCP - System is open for extension (new notifiers) but closed for modification
        notifiers.forEach(n -> n.send(savedTask));

        return savedTask;
    }
}