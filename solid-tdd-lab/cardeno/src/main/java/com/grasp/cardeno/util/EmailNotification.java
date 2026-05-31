package com.grasp.cardeno.util;

import com.grasp.cardeno.entity.Task;
import org.springframework.stereotype.Component;

// GRASP: Polymorphism - This is one of many forms the notification can take
@Component
public class EmailNotification implements NotificationStrategy {
    @Override
    public void send(Task task) {
        System.out.println("Sending Email for task: " + task.getTitle());
    }
}