package com.caneda.fullstack.repository;

import com.caneda.fullstack.entity.CoinFlip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CoinFlipRepository extends JpaRepository<CoinFlip, Long> {
    List<CoinFlip> findByUserId(Long userId);
    @Transactional
    void deleteByUserId(Long userId);

}
