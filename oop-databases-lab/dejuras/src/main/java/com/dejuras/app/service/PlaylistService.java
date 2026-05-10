package com.dejuras.app.service;

import com.dejuras.app.entity.Playlist;
import com.dejuras.app.exception.ResourceNotFoundException;
import com.dejuras.app.repository.PlaylistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlaylistService {

    private final PlaylistRepository playlistRepository;

    public List<Playlist> getAllPlaylists() {
        return playlistRepository.findAll();
    }

    public Playlist getPlaylist(Long id) {
        return playlistRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Playlist not found: " + id));
    }

    public Playlist createPlaylist(Playlist playlist) {
        return playlistRepository.save(playlist);
    }

    public Playlist updatePlaylist(Long id, Playlist playlist) {
        Playlist existing = getPlaylist(id);

        existing.setArtist(playlist.getArtist());
        existing.setSong(playlist.getSong());
        existing.setDuration(playlist.getDuration());

        return playlistRepository.save(existing);
    }

    public void deletePlaylist(Long id) {
        getPlaylist(id);
        playlistRepository.deleteById(id);
    }
}