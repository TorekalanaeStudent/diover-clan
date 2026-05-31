package com.grasp.cardeno.controller;

import com.grasp.cardeno.dto.TaskDTO;
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
    public ResponseEntity<Task> create(@RequestBody TaskDTO dto) {
        // Controller acts as the entry point (GRASP: Controller)
        Task createdTask = service.createTask(dto);
        return ResponseEntity.ok(createdTask);
    }
}