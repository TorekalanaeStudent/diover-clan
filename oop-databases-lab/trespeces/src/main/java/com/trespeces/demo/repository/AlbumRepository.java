package com.trespeces.demo.repository;

import com.trespeces.demo.entity.Album;
import com.trespeces.demo.entity.Idol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Long> {

}