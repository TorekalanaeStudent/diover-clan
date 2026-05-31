package com.grasp.cardeno.util;

import com.grasp.cardeno.entity.Task;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

class NotificationStrategyTest {

    // SOLID: ISP - Testing the granular interface implementation
    // GRASP: Polymorphism - Testing that different implementations work via the interface

    @Test
    void testEmailNotificationImplementation() {
        Task task = new Task(1L, "Email Test", LocalDate.now(), false);
        NotificationStrategy email = new EmailNotification();
        assertDoesNotThrow(() -> email.send(task));
    }

    @Test
    void testSmsNotificationImplementation() {
        Task task = new Task(1L, "SMS Test", LocalDate.now(), false);
        NotificationStrategy sms = new SmsNotification();
        assertDoesNotThrow(() -> sms.send(task));
    }
}