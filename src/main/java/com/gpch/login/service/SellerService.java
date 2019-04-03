package com.gpch.login.service;


import com.gpch.login.model.rma.Seller;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface SellerService  {
    ResponseEntity<Optional<Seller>> findById(Long id);
    ResponseEntity<Seller> findByInitials(String initials);
    ResponseEntity<List<Seller>> findAllSeller();
    ResponseEntity<Seller> addNewSellerEnt(Seller seller);
    ResponseEntity<Seller> updateSellerById(long id, Seller seller);
}
