package com.grasp.cardeno.entity;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

// SOLID: SRP - This class tests only the domain rules for the Task entity.
class TaskDomainTest {

    @Test
    void shouldBeOverdueIfDeadlineInPast() {
        Task t = new Task(1L, "Past Task", LocalDate.now().minusDays(1), false);
        assertTrue(t.isOverdue());
    }

    @Test
    void shouldNotBeOverdueIfDeadlineInFuture() {
        Task t = new Task(1L, "Future Task", LocalDate.now().plusDays(1), false);
        assertFalse(t.isOverdue());
    }

    @Test
    void shouldNotBeOverdueIfCompleted() {
        Task t = new Task(1L, "Completed Task", LocalDate.now().minusDays(1), true);
        assertFalse(t.isOverdue());
    }

    @Test
    void shouldNotBeOverdueIfDeadlineIsNull() {
        Task t = new Task(1L, "No Date", null, false);
        assertFalse(t.isOverdue());
    }

    @Test
    void shouldNotBeOverdueIfDeadlineIsToday() {
        Task t = new Task(1L, "Due Today", LocalDate.now(), false);
        assertFalse(t.isOverdue()); // Today is not "before" now, so it's not overdue
    }
}