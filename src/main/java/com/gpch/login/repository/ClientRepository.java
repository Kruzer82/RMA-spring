package com.gpch.login.repository;

import com.gpch.login.model.rma.Client;
import com.gpch.login.model.rma.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    List<Client> findAll();
    Client findById(long id);
    Client findByEMail(String emeil);
    Client findByPerson(String person);
    Client findByPhoneNumber(String phoneNumber);
    Client findBySeller(Seller seller);
    Client findByName(String ClientName);
}
