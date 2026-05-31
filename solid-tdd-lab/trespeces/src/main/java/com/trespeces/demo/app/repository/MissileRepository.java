package com.trespeces.demo.app.repository;

import com.trespeces.demo.app.entity.Missile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

// GRASP: Indirection - Repository acts as a layer between DB and Service
// GRASP: Protected Variations - DB implementation can change without affecting Service
@Repository
public interface MissileRepository extends JpaRepository<Missile, Long> {
    List<Missile> findByStatus(String status);
    List<Missile> findByType(String type);
}
