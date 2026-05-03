package com.trespeces.demo.repository;

import com.trespeces.demo.entity.Idol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IdolRepository extends JpaRepository<Idol, Long> {

}
