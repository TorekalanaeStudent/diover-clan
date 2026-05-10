package com.caneda.fullstack.service;

import com.caneda.fullstack.entity.CoinFlip;
import com.caneda.fullstack.entity.User;
import com.caneda.fullstack.repository.CoinFlipRepository;
import com.caneda.fullstack.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

@Service
public class CoinFlipService {

    @Autowired
    private CoinFlipRepository coinFlipRepository;

    @Autowired
    private UserRepository userRepository;

    // Flip a coin for a specific user
    public CoinFlip flip(Long userId, String userChoice) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        String result = new Random().nextBoolean() ? "heads" : "tails";
        boolean won = userChoice.equalsIgnoreCase(result);

        CoinFlip flip = new CoinFlip();
        flip.setUser(user);
        flip.setUserChoice(userChoice);
        flip.setOutCome(result);
        flip.setWinOrNo(won);
        flip.setTimeFlippedAt(LocalDateTime.now());

        return coinFlipRepository.save(flip);
    }

    // Get all flips for a specific user
    public List<CoinFlip> getFlipsByUser(Long userId) {
        return coinFlipRepository.findByUserId(userId);
    }


}