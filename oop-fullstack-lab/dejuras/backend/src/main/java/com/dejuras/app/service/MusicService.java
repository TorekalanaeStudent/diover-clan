package com.dejuras.app.service;

import com.dejuras.app.model.Music;
import com.dejuras.app.repository.MusicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MusicService {

    private final MusicRepository musicRepository;

    public List<Music> getAllMusic() {
        return musicRepository.findAll();
    }

    public Music getMusicById(Long id) {
        return musicRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Music not found with id: " + id));
    }

    public Music createMusic(Music music) {
        music.setId(null); // prevent client forcing an ID
        return musicRepository.save(music);
    }

    public Music updateMusic(Long id, Music updated) {
        Music existing = getMusicById(id);
        existing.setTitle(updated.getTitle());
        existing.setArtist(updated.getArtist());
        existing.setAlbum(updated.getAlbum());
        existing.setGenre(updated.getGenre());
        existing.setDuration(updated.getDuration());
        return musicRepository.save(existing);
    }

    public void deleteMusic(Long id) {
        if (!musicRepository.existsById(id)) {
            throw new RuntimeException("Music not found with id: " + id);
        }
        musicRepository.deleteById(id);
    }
}
