package com.gpch.login.repository;

import com.gpch.login.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import sun.jvm.hotspot.memory.LinearAllocBlock;

import java.time.LocalDateTime;
import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Long> {
    public Client getClientById(long id);

}
