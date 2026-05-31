package com.grasp.cardeno.util;

import com.grasp.cardeno.entity.Task;
import org.springframework.stereotype.Component;

// GRASP: Polymorphism - Swappable behavior for different channels
@Component
public class SmsNotification implements NotificationStrategy {
    @Override
    public void send(Task task) {
        System.out.println("Sending SMS for task: " + task.getTitle());
    }
}