package com.go.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.go.entity.BackendEntity;

public interface BackendRepository extends JpaRepository<BackendEntity, Long> {
}