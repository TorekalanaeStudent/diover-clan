package com.grasp.cardeno.exception;

// GRASP: Pure Fabrication & High Cohesion - A class that handles error concerns separately from business logic.
public class TaskNotFoundException extends RuntimeException {
    public TaskNotFoundException(Long id) { super("Task not found: " + id); }
}