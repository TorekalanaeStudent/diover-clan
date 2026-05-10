package com.caneda.fullstack.repository;

import com.caneda.fullstack.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// JpaRepository gives us all basic CRUD methods for free
// First type = Entity class, Second type = ID type
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // You can add custom queries here if needed
    // Example: List<User> findByName(String name);
}