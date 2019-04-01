package com.gpch.login.service;

import com.gpch.login.model.Seller;
import com.gpch.login.repository.SellerRepository;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    private SellerRepository sellerRepository;


    @Override
    public Optional<Seller> findSellerById(Long id) {
        return sellerRepository.findById(id);
    }

    @Override
    public Seller findSellerByInitials(String initials) {
        return sellerRepository.findByInitials(initials);
    }

    @Override
    public List<Seller> findAllSeller() {
        return sellerRepository.findAll();
    }

    @Override
    public Seller addNewSeller(Seller seller){
        if(sellerRepository.existsByNameAndInitials(seller.getName(),seller.getInitials())) return sellerRepository.findByNameAndInitials(seller.getName(),seller.getInitials());
        else
        return sellerRepository.save(seller);
    }
}
