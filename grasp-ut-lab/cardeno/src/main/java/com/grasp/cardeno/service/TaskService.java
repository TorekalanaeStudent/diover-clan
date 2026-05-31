package com.grasp.cardeno.service;

import com.grasp.cardeno.dto.TaskDTO;
import com.grasp.cardeno.entity.Task;
import com.grasp.cardeno.repository.TaskRepository;
import com.grasp.cardeno.util.NotificationStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

// GRASP: Pure Fabrication - Service coordinates tasks and separates business logic from entities
@Service
@RequiredArgsConstructor
public class TaskService {

    // GRASP: Low Coupling - Service depends on the NotificationStrategy interface, not concrete classes
    private final TaskRepository repo;
    private final List<NotificationStrategy> notifiers;

    // GRASP: Creator - Service is responsible for instantiating the Task entity
    // GRASP: High Cohesion - Service is focused solely on task-related business validation and processing
    public Task createTask(TaskDTO dto) {
        // Edge Case Handling: Validation logic
        if (dto == null) throw new IllegalArgumentException("Task cannot be null");
        if (dto.getTitle() == null || dto.getTitle().trim().isEmpty()) {
            throw new IllegalArgumentException("Task title is required");
        }

        Task task = new Task(null, dto.getTitle(), dto.getDueDate(), false);
        Task savedTask = repo.save(task);

        // GRASP: Polymorphism - Executes different notification behaviors via the same interface method
        // GRASP: Protected Variations - Adding new notification types won't require changes to this code
        notifiers.forEach(n -> n.send(savedTask));

        return savedTask;
    }
}