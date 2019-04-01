package com.gpch.login.service;


import com.gpch.login.model.Seller;

import java.util.List;
import java.util.Optional;

public interface SellerService  {
    Optional<Seller> findSellerById(Long id);
    Seller findSellerByInitials(String initials);
    List<Seller> findAllSeller();
    Seller addNewSeller(Seller seller);
}
