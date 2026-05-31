package com.grasp.cardeno.service;

import com.grasp.cardeno.dto.TaskDTO;
import com.grasp.cardeno.entity.Task;
import com.grasp.cardeno.repository.TaskRepository;
import com.grasp.cardeno.util.NotificationStrategy;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

// GRASP: Low Coupling - Test interacts with abstractions rather than concrete implementations
@ExtendWith(MockitoExtension.class)
class TaskServiceTest {

    // GRASP: Indirection - Decouples business logic from the database storage layer
    @Mock
    private TaskRepository repo;

    @Mock
    private List<NotificationStrategy> notifiers;

    // GRASP: Pure Fabrication - Service is an object designed to coordinate business processes
    @InjectMocks
    private TaskService service;

    // GRASP: Creator - Verifies the service correctly orchestrates the creation of a Task
    @Test
    void shouldCreateTaskSuccessfully() {
        // Arrange
        TaskDTO dto = new TaskDTO("Study GRASP", LocalDate.now());
        when(repo.save(any(Task.class))).thenReturn(new Task(1L, "Study GRASP", LocalDate.now(), false));

        // Act
        Task result = service.createTask(dto);

        // Assert
        assertNotNull(result);
        assertEquals("Study GRASP", result.getTitle());
        verify(repo, times(1)).save(any(Task.class));
    }

    // GRASP: Information Expert - Verifies logic resides within the object that owns the data
    @Test
    void overdueCheckReturnsTrueForPastDate() {
        Task t = new Task(1L, "Past Task", LocalDate.now().minusDays(1), false);
        assertTrue(t.isOverdue(), "Task should be overdue if deadline is in the past");
    }

    // GRASP: Information Expert - Validating edge case where logic determines state correctly
    @Test
    void overdueCheckReturnsFalseForFutureDate() {
        Task t = new Task(1L, "Future Task", LocalDate.now().plusDays(1), false);
        assertFalse(t.isOverdue(), "Task should not be overdue if deadline is in the future");
    }

    // GRASP: Information Expert - Domain logic stays with the entity
    @Test
    void overdueCheckReturnsFalseForCompletedTask() {
        Task t = new Task(1L, "Done", LocalDate.now().minusDays(1), true);
        assertFalse(t.isOverdue(), "Completed tasks should never be overdue");
    }

    // GRASP: Protected Variations - Ensures the service handles unexpected failures predictably
    @Test
    void shouldThrowExceptionWhenRepoFails() {
        when(repo.save(any())).thenThrow(new RuntimeException("Database error"));
        assertThrows(RuntimeException.class, () -> service.createTask(new TaskDTO("Error", LocalDate.now())));
    }
}