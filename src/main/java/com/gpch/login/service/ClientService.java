package com.gpch.login.service;

import com.gpch.login.model.rma.Client;
import com.gpch.login.model.rma.Seller;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public interface ClientService {
    ResponseEntity<List<Client>> getAllClient();
    ResponseEntity<Optional<Client>> getClientById(Long id);
    ResponseEntity<Client> getClientByName(String name);
    ResponseEntity<Client> getClientByPerson(String person);
    ResponseEntity<Client> getClientByPhoneNumber(String phoneNumber);
    ResponseEntity<Client> getClientBySeller(Seller seller);
    ResponseEntity<Client> getClientByEmail(String email);
    ResponseEntity<Client> updateClientById(long id, Client client);
}
