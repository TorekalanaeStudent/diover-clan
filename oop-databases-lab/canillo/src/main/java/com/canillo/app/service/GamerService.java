package com.canillo.app.service;

import com.canillo.app.entity.Gamer;
import com.canillo.app.exception.ResourceNotFoundException;
import com.canillo.app.repository.GamerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GamerService {

    private final GamerRepository gamerRepository;

    public List<Gamer> getAllGamers() {
        return gamerRepository.findAll();
    }

    public Gamer getGamerById(Long id) {
        return gamerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Gamer not found wit id: " + id));
    }

    public Gamer createGamer(Gamer gamer) {
        return gamerRepository.save(gamer);
    }

    public Gamer updateGamer(Long id, Gamer gamer) {
        Gamer existing = getGamerById(id);

        existing.setName(gamer.getName());
        existing.setEmail(gamer.getEmail());
        existing.setPhoneNumber(gamer.getPhoneNumber());
        existing.setIsProGamer(gamer.getIsProGamer());
        existing.setRank(gamer.getRank());

        return gamerRepository.save(existing);
    }

    public void deleteGamer(Long id) {
        getGamerById(id);
        gamerRepository.deleteById(id);
    }
}
