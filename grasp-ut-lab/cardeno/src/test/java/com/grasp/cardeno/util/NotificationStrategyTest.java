package com.grasp.cardeno.util;

import com.grasp.cardeno.entity.Task;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

class NotificationStrategyTest {

    // GRASP: Polymorphism - Testing interchangeable implementations
    // GRASP: Protected Variations - Ensuring stable test against future changes
    @Test
    void testPolymorphicBehavior() {
        Task task = new Task(1L, "Test Task", LocalDate.now(), false);
        NotificationStrategy email = new EmailNotification();
        NotificationStrategy sms = new SmsNotification();

        assertDoesNotThrow(() -> email.send(task));
        assertDoesNotThrow(() -> sms.send(task));
    }
}