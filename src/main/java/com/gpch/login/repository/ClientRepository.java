package com.gpch.login.repository;

import com.gpch.login.model.rma.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    Client getById(int id);
    Client getByName(String ClientName);
}
