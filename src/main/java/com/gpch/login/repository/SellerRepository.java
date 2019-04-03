package com.gpch.login.repository;

import com.gpch.login.model.rma.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SellerRepository extends JpaRepository<Seller,Long> {
    List<Seller> findAll();
    Seller findByInitials(String initials);
    Seller findByName(String name);
    Seller findById(long id);

}
