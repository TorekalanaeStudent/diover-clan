package com.grasp.jagunap.util;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// GRASP: Tests Polymorphism — all implementations share same interface
class NotificationStrategyTest {

    @Test
    void emailNotificationShouldReturnCorrectType() {
        NotificationStrategy strategy = new EmailNotification();
        assertEquals("EMAIL", strategy.getNotificationType());
    }

    @Test
    void smsNotificationShouldReturnCorrectType() {
        NotificationStrategy strategy = new SmsNotification();
        assertEquals("SMS", strategy.getNotificationType());
    }

    @Test
    void emailShouldSendWithoutError() {
        NotificationStrategy strategy = new EmailNotification();
        assertDoesNotThrow(() -> strategy.sendNotification("Test message"));
    }

    @Test
    void smsShouldSendWithoutError() {
        NotificationStrategy strategy = new SmsNotification();
        assertDoesNotThrow(() -> strategy.sendNotification("Test message"));
    }
}