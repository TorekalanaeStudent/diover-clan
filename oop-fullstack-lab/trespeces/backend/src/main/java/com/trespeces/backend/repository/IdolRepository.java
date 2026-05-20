package com.trespeces.backend.repository;

import com.trespeces.backend.entity.Idol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IdolRepository extends JpaRepository<Idol, Long> {
}