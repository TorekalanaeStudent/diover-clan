package com.arban.app.service;

import com.arban.app.entity.Athlete;
import com.arban.app.exception.ResourceNotFoundException;
import com.arban.app.repository.AthleteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AthleteService {

    private final AthleteRepository athleteRepository;

    public List<Athlete> getAllAthletes() {
        return athleteRepository.findAll();
    }

    public Athlete getAthleteById(Long id) {
        return athleteRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Athlete not found with id: " + id));
    }

    public Athlete createAthlete(Athlete athlete) {
        return athleteRepository.save(athlete);
    }

    public Athlete updateAthlete(Long id, Athlete athlete) {
        Athlete existing = getAthleteById(id);
        existing.setName(athlete.getName());
        existing.setEmail(athlete.getEmail());
        existing.setPhoneNumber(athlete.getPhoneNumber());
        existing.setProAthlete(athlete.isProAthlete());
        existing.setSports(athlete.getSports());
        return athleteRepository.save(existing);
    }

    public void deleteAthlete(Long id) {
        getAthleteById(id);
        athleteRepository.deleteById(id);
    }
}