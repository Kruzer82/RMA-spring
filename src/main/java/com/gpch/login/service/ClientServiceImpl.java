package com.gpch.login.service;

import com.gpch.login.model.Client;
import com.gpch.login.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;


    @Override
    public List<Client> getAllClient() {
        return clientRepository.findAll();
    }
}
