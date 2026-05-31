package com.caneda.springboot.repository;

import com.caneda.springboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

// GRASP: Indirection - acts as layer between DB and service
// GRASP: Protected Variations - if DB changes, only repository changes
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserName(String userName);
    User findByUserEmail(String userEmail);
    User findByUserAge(int age);
}