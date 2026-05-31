package com.grasp.cardeno.repository;

import com.grasp.cardeno.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// GRASP: Indirection - Decouples service from database
@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
}