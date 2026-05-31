package com.grasp.cardeno.util;

import com.grasp.cardeno.entity.Task;

// GRASP: Polymorphism - Defines a common interface to allow different notification implementations.
// GRASP: Protected Variations - Ensures the system is stable against future additions of new notification types
// GRASP: Low Coupling
public interface NotificationStrategy {
    void send(Task task);
}