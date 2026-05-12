package com.dejuras.app.repository;

import com.dejuras.app.model.Music;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MusicRepository extends JpaRepository<Music, Long> {
    List<Music> findByArtistContainingIgnoreCase(String artist);
    List<Music> findByGenreIgnoreCase(String genre);
}
