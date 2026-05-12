package com.trespeces.backend.service;

import com.trespeces.backend.entity.Idol;
import com.trespeces.backend.repository.IdolRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IdolService {

    private final IdolRepository idolRepository;

    public List<Idol> getAllIdols() {
        return idolRepository.findAll();
    }

    public Idol getIdolById(Long id) {
        return idolRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Idol not found: " + id));
    }

    public Idol createIdol(Idol idol) {
        return idolRepository.save(idol);
    }

    public Idol updateIdol(Long id, Idol idol) {
        Idol existing = getIdolById(id);
        existing.setName(idol.getName());
        existing.setGroup(idol.getGroup());
        existing.setCompany(idol.getCompany());
        return idolRepository.save(existing);
    }

    public void deleteIdol(Long id) {
        idolRepository.deleteById(id);
    }
}