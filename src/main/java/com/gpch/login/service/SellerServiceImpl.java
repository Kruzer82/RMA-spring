package com.gpch.login.service;

import com.gpch.login.model.rma.Seller;
import com.gpch.login.repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SellerServiceImpl implements SellerService {

    private SellerRepository sellerRepository;

    private SellerService sellerService;

    public SellerServiceImpl(SellerRepository sellerRepository, SellerService sellerService) {
        this.sellerRepository = sellerRepository;
        this.sellerService = sellerService;
    }

    @Override
    public ResponseEntity<Optional<Seller>> findById(Long id) {
        return new ResponseEntity<>(sellerRepository.findById(id),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Seller> findByInitials(String initials) {
        return new ResponseEntity<>(sellerRepository.findByInitials(initials), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Seller>> findAllSeller() {
        return new ResponseEntity<>(sellerRepository.findAll(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Seller> addNewSellerEnt(Seller seller) {
        seller.setId(null);
        if(
                (sellerRepository.findByInitials(seller.getInitials()) != null) || (sellerRepository.findByName(seller.getName()) != null)){
            return new ResponseEntity<>(seller, HttpStatus.ALREADY_REPORTED);
        }
        else return new ResponseEntity<>(sellerRepository.save(seller), HttpStatus.OK);
    }


    @Override
    public ResponseEntity<Seller> updateSellerById(long id, Seller seller) {
        Seller fromdb = null;
        if(sellerRepository.findById(id) != null) {
            fromdb = sellerRepository.findById(id);
            fromdb.setInitials(seller.getInitials());
            fromdb.setName(seller.getName());
            return new ResponseEntity<>(sellerRepository.save(fromdb),HttpStatus.OK);
        }
        return new ResponseEntity<>(fromdb,HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<Optional<Seller>> deleteNewSellerEnt(Long id) {
        Seller seller = new Seller();
        try {
            sellerRepository.deleteById(id);
            return new ResponseEntity<>(Optional.of(seller),HttpStatus.OK);
        }
        catch (EmptyResultDataAccessException e){
            return new ResponseEntity<>(Optional.of(seller),HttpStatus.CONFLICT);
        }
    }

//    @Override
//    public ResponseEntity<Optional<Seller>> deleteNewSellerEnt(Long id) {
//        Seller seller = new Seller();
//
//        return new ResponseEntity<>(sellerService.deleteNewSellerEnt(id),HttpStatus.OK);
//    }
}
