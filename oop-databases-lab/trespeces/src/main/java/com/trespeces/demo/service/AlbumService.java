package com.trespeces.demo.service;

import com.trespeces.demo.entity.Album;
import com.trespeces.demo.exception.ResourceNotFoundException;
import com.trespeces.demo.repository.AlbumRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AlbumService {

    private final AlbumRepository albumRepository;

    /**
     * C - Create
     * R - Read
     * u - Update
     * D - Delete
     */

    public List<Album> getAllAlbums() {
        return albumRepository.findAll();
    }

    public Album getAlbumById(Long id) {
        return albumRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Album not found within the database" + id));
    }

    public Album createAlbum(Album album) {
        return albumRepository.save(album);
    }

    public Album updateAlbum(Long id, Album album) {
        Album existing = getAlbumById(id);

        existing.setTitle(album.getTitle());
        existing.setArtist(album.getArtist());
        existing.setGenre(album.getGenre());
        existing.setLabel(album.getLabel());
        existing.setPrice(album.getPrice());

        return albumRepository.save(existing);
    }

    public void deleteAlbum(Long id) {
        albumRepository.deleteById(id);
    }
}