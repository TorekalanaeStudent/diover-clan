package com.gedoria.app.service;

import com.gedoria.app.entity.Buyer;
import com.gedoria.app.exception.ResourceNotFoundException;
import com.gedoria.app.repository.BuyerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuyerService {

    private final BuyerRepository buyerRepository;

    public BuyerService(BuyerRepository buyerRepository) {
        this.buyerRepository = buyerRepository;
    }

    public Buyer createBuyer(Buyer buyer) {
        return buyerRepository.save(buyer);
    }

    public List<Buyer> getAllBuyers() {
        return buyerRepository.findAll();
    }

    public Buyer getBuyerById(Long id) {
        return buyerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Buyer not found with id: " + id));
    }

    public Buyer updateBuyer(Long id, Buyer buyerDetails) {
        Buyer buyer = getBuyerById(id);

        buyer.setName(buyerDetails.getName());
        buyer.setPhoneNumber(buyerDetails.getPhoneNumber());
        buyer.setEmail(buyerDetails.getEmail());
        buyer.setTrusted(buyerDetails.isTrusted());
        buyer.setWallet(buyerDetails.getWallet());

        return buyerRepository.save(buyer);
    }

    public void deleteBuyer(Long id) {
        Buyer buyer = getBuyerById(id);
        buyerRepository.delete(buyer);
    }
}
