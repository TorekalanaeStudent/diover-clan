package com.trespeces.demo.service;

import com.trespeces.demo.entity.Idol;
import com.trespeces.demo.exception.ResourceNotFoundException;
import com.trespeces.demo.repository.IdolRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class IdolService {

    private final IdolRepository idolRepository;

    /**
     * C - Create
     * R - Read
     * u - Update
     * D - Delete
     */

    public List<Idol> getAllIdols() {
        return idolRepository.findAll();
    }

    public Idol getIdolById(Long id) {
        return idolRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Idol not found within the database" + id));
    }

    public Idol createIdol(Idol idol) {
        return idolRepository.save(idol);
    }

    public Idol updateIdol(Long id, Idol idol) {
        Idol existing = getIdolById(id);

        existing.setName(idol.getName());
        existing.setGroup(idol.getGroup());
        existing.setPosition(idol.getPosition());
        existing.setSenior(idol.isSenior());
        existing.setCompany(idol.getCompany());

        return idolRepository.save(existing);
    }

    public void deleteIdol(Long id) {
        idolRepository.deleteById(id);
    }
}
