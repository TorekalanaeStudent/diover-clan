package com.grasp.jagunap.util;

import org.springframework.stereotype.Component;

// GRASP: Polymorphism — EmailNotification is one concrete implementation
//        of NotificationStrategy
// GRASP: Pure Fabrication — exists to handle notification logic
//        separately from business logic
@Component
public class EmailNotification implements NotificationStrategy {

    @Override
    public void sendNotification(String message) {
        System.out.println("Sending EMAIL notification: " + message);
    }

    @Override
    public String getNotificationType() {
        return "EMAIL";
    }
}