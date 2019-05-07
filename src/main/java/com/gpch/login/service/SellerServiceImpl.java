package com.gpch.login.service;

import com.gpch.login.model.rma.Seller;
import com.gpch.login.repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SellerServiceImpl implements SellerService {
    @Autowired
    private SellerRepository sellerRepository;
    @Autowired
    private SellerService sellerService;

    @Override
    public Seller findById(Long id) {
        return sellerRepository.findById(id).orElse(new Seller());
    }

    @Override
    public Seller findByInitials(String initials) {
        return sellerRepository.findByInitials(initials);
    }

    @Override
    public List<Seller> findAllSeller() {
        return sellerRepository.findAll();
    }

    @Override
    public Seller addNewSellerEnt(Seller seller) {
        return sellerRepository.save(seller);
    }

    @Override
    public Seller updateSellerById(long id, Seller seller) {
        return sellerRepository.save(seller);
    }


    @Override
    public boolean isSellerExist(Seller seller) {
        return sellerRepository.existsByNameOrInitials(seller.getName(),seller.getInitials());
    }

    @Override
    public Seller updateSeller(Seller currentSeller) {
        return sellerRepository.save(currentSeller);
    }

    @Override
    public void deleteSellerById(long id) {
        sellerRepository.deleteById(id);
    }
}
