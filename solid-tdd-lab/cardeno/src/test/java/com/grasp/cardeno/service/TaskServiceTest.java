package com.grasp.cardeno.service;

import com.grasp.cardeno.dto.TaskDTO;
import com.grasp.cardeno.entity.Task;
import com.grasp.cardeno.repository.TaskRepository;
import com.grasp.cardeno.util.NotificationStrategy;
import com.grasp.cardeno.validation.TaskValidator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.time.LocalDate;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TaskServiceTest {
    @Mock private TaskRepository repo;
    @Mock private TaskValidator validator;
    @Mock private List<NotificationStrategy> notifiers;

    @InjectMocks
    private TaskService service;

    @Test
    void shouldCreateTaskSuccessfully() {
        TaskDTO dto = new TaskDTO("Study SOLID", LocalDate.now());
        when(repo.save(any(Task.class))).thenReturn(new Task(1L, "Study SOLID", LocalDate.now(), false));

        Task result = service.createTask(dto);

        assertNotNull(result);
        verify(validator).validate(dto); // Verifies SRP
        verify(repo).save(any(Task.class));
    }

    @Test
    void shouldThrowExceptionForInvalidTask() {
        TaskDTO invalidDto = new TaskDTO("", null);
        // DIP: Testing that the service relies on the validator's contract
        doThrow(new IllegalArgumentException()).when(validator).validate(invalidDto);

        assertThrows(IllegalArgumentException.class, () -> service.createTask(invalidDto));
    }

    // DIP/Protected Variations: Verifies service-to-repository interaction in isolation.
    @Test
    void shouldVerifyRepositorySaveInteractions() {
        TaskDTO dto = new TaskDTO("Save Test", LocalDate.now());
        when(repo.save(any())).thenReturn(new Task(1L, "Save Test", LocalDate.now(), false));
        service.createTask(dto);
        verify(repo, times(1)).save(any(Task.class));
    }

    // OOP Practice: Programming to an interface (Repository) for testability.
    @Test
    void shouldHandleRepositoryFailureGracefully() {
        TaskDTO dto = new TaskDTO("Fail Test", LocalDate.now());

        // Isolation: Stubbing failure behavior
        when(repo.save(any(Task.class))).thenThrow(new RuntimeException("Database down"));

        // Encapsulation: Validating predictable error propagation
        assertThrows(RuntimeException.class, () -> service.createTask(dto));
    }
}