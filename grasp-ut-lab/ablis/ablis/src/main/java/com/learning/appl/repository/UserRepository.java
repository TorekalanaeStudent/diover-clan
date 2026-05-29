package com.learning.appl.repository;

import com.learning.appl.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// database
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
