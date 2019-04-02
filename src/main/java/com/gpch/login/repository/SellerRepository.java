package com.gpch.login.repository;

import com.gpch.login.model.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SellerRepository extends JpaRepository<Seller,Long> {
    List<Seller> findAll();
    Seller findByInitials(String initials);
    Boolean existsByNameAndInitials(String name,String initials);
    Seller findByNameAndInitials(String name, String initials);
    Seller findByName(String name);
    Seller findByInitials(Long id);
}
