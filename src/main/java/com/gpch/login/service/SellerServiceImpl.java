package com.gpch.login.service;

import com.gpch.login.model.Seller;
import com.gpch.login.repository.SellerRepository;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
        if((sellerRepository.findByInitials(seller.getId()) != null) || (sellerRepository.findByName(seller.getName()) != null)){
            return seller;
        }
        else return sellerRepository.save(seller);

//        if(sellerRepository.existsByNameAndInitials(seller.getName(),seller.getInitials())) return sellerRepository.findByNameAndInitials(seller.getName(),seller.getInitials());
//        else
//        return sellerRepository.save(seller);
    }

    @Override
    public ResponseEntity<Seller> addNewSellerEnt(Seller seller) {
        seller.setId(null);
        if(
                (sellerRepository.findByInitials(seller.getInitials()) != null) || (sellerRepository.findByName(seller.getName()) != null)){
            return new ResponseEntity<Seller>(seller, HttpStatus.ALREADY_REPORTED);
        }
        else return new ResponseEntity<Seller>(sellerRepository.save(seller), HttpStatus.OK);
    }
}
