package com.gpch.login.service;


import com.gpch.login.model.rma.Seller;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface SellerService  {
    Seller findById(Long id);
    Seller findByInitials(String initials);
    List<Seller> findAllSeller();
    Seller addNewSellerEnt(Seller seller);
    Seller updateSellerById(long id, Seller seller);
    boolean isSellerExist(Seller seller);
    Seller updateSeller(Seller currentSeller);
    void deleteSellerById(long id);
}
