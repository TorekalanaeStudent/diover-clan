package com.jagunap.springboot.repository;

import com.jagunap.springboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

// Abstraction: hides database implementation details
// Separation of concerns: only handles data access
public interface UserRepository extends JpaRepository<User, Long> {
}