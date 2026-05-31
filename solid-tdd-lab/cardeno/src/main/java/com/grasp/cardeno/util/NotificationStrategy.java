package com.grasp.cardeno.util;

import com.grasp.cardeno.entity.Task;

// SOLID: ISP - Interface is small and focused; clients are not forced to implement unwanted methods
// SOLID: Open-Closed Principle: To add a new notification, you add a new class implementing this interface.
// GRASP: Protected Variations - Adding a new notifier does not affect existing code
public interface NotificationStrategy {
    void send(Task task);
}