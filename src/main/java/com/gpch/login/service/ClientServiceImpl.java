package com.gpch.login.service;

import com.gpch.login.model.rma.Client;
import com.gpch.login.model.rma.Seller;
import com.gpch.login.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public ResponseEntity<List<Client>> getAllClient() {
        return new ResponseEntity<>(clientRepository.findAll(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Optional<Client>> getClientById(Long id) {
        return new ResponseEntity<>(clientRepository.findById(id),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Client> getClientByName(String name) {
        return new ResponseEntity<>(clientRepository.findByName(name), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Client> getClientByPerson(String person) {
        return new ResponseEntity<>(clientRepository.findByPerson(person), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Client> getClientByPhoneNumber(String phoneNumber) {
        return new ResponseEntity<>(clientRepository.findByPhoneNumber(phoneNumber), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Client> getClientBySeller(Seller seller) {
        return new ResponseEntity<>(clientRepository.findBySeller(seller), HttpStatus.OK);    }

    @Override
    public ResponseEntity<Client> getClientByEmail(String email) {
        return new ResponseEntity<>(clientRepository.findByEMail(email), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Client> updateClientById(long id, Client client) {
        Client fromdb = null;
        if(clientRepository.findById(id) != null) {
            fromdb = clientRepository.findById(id);
            fromdb.setEMail(client.getEMail());
            fromdb.setName(client.getName());
            fromdb.setPerson(client.getPerson());
            fromdb.setPhoneNumber(client.getPhoneNumber());
            fromdb.setSeller(client.getSeller());
            return new ResponseEntity<>(clientRepository.save(fromdb),HttpStatus.OK);
        }
        return new ResponseEntity<>(fromdb,HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<Client> save(Client client) {
        return new ResponseEntity<>(clientRepository.save(client),HttpStatus.OK);
    }
}
