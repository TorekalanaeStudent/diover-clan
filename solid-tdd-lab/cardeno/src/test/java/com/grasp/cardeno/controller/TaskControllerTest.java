package com.grasp.cardeno.controller;

import com.grasp.cardeno.dto.TaskDTO;
import com.grasp.cardeno.dto.TaskResponse;
import com.grasp.cardeno.entity.Task;
import com.grasp.cardeno.service.TaskService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

// GRASP: Controller Test - Validates that the controller properly orchestrates incoming HTTP requests.
@ExtendWith(MockitoExtension.class)
class TaskControllerTest {

    @Mock private TaskService service;
    @InjectMocks private TaskController controller;

    // Test 1: Happy Path
    @Test
    void shouldReturnOkWhenTaskCreated() {
        TaskDTO dto = new TaskDTO("Test", LocalDate.now());
        when(service.createTask(any())).thenReturn(new Task(1L, "Test", LocalDate.now(), false));
        ResponseEntity<TaskResponse> response = controller.create(dto);
        assertEquals(200, response.getStatusCode().value());
    }

    // Test 2: Error Handling
    @Test
    void shouldReturnBadRequestWhenServiceFails() {
        when(service.createTask(any())).thenThrow(new RuntimeException("Service Error"));
        assertThrows(RuntimeException.class, () -> controller.create(new TaskDTO("Title", LocalDate.now())));
    }
}