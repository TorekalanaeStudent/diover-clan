package com.grasp.jagunap.util;

// GRASP: Polymorphism — defines a common interface for all notification types
// GRASP: Protected Variations — shields the system from changes in
//        notification methods. Adding a new one = just add a new class
public interface NotificationStrategy {
    void sendNotification(String message);
    String getNotificationType();
}