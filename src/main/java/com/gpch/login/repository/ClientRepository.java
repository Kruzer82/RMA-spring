package com.gpch.login.repository;

import com.gpch.login.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    Client getClientById(long id);
    Client getById(int id);


}
