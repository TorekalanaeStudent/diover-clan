package com.grasp.cardeno.controller;

import com.grasp.cardeno.dto.TaskDTO;
import com.grasp.cardeno.dto.TaskResponse;
import com.grasp.cardeno.entity.Task;
import com.grasp.cardeno.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// GRASP: Controller - Handles incoming request
// GRASP: High Cohesion - This class is solely responsible for HTTP request routing and delegation
@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService service;

    public TaskController(TaskService service) { this.service = service; }

    @PostMapping
    public ResponseEntity<TaskResponse> create(@RequestBody TaskDTO dto) {
        // 1. Delegate business logic to service
        Task savedTask = service.createTask(dto);

        // 2. Transform the Entity into a Response DTO (Hiding internal database structure)
        TaskResponse response = new TaskResponse(savedTask.getId(), savedTask.getTitle());

        return ResponseEntity.ok(response);
    }
}