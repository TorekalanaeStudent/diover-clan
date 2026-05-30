package com.grasp.jagunap.util;

import org.springframework.stereotype.Component;

// GRASP: Polymorphism — SmsNotification is a second concrete implementation
//        of NotificationStrategy
// GRASP: Pure Fabrication — exists to handle notification logic
//        separately from business logic
@Component
public class SmsNotification implements NotificationStrategy {

    @Override
    public void sendNotification(String message) {
        System.out.println("Sending SMS notification: " + message);
    }

    @Override
    public String getNotificationType() {
        return "SMS";
    }
}