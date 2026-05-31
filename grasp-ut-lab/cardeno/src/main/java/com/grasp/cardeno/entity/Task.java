package com.grasp.cardeno.entity;

/* @author: @flcardeno (Cardeño, Faye L.) */

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
// GRASP: High Cohesion - Task only manages task data
public class Task {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private LocalDate deadline;
    private boolean isCompleted;

    // GRASP: Information Expert - Task calculates its own status
    public boolean isOverdue() {
        return !isCompleted && deadline.isBefore(LocalDate.now());
    }
}