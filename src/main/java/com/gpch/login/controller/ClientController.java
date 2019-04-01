package com.gpch.login.controller;

import com.gpch.login.model.Client;
import com.gpch.login.service.ClientService;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SuppressWarnings("Duplicates")

@RestController
public class ClientController {

    private ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/json/client")
    public List<Client> getAllClient(){
        return clientService.getAllClient();
    }

    @PostMapping("/json/client/add")
    public Client addClient(Client client, @RequestParam("initials") Long initials){
        return new Client();
    }

    @PutMapping("/json/client/add")
    public Client putClient(Client client, @RequestParam("initials") Long initials){
        return new Client();
    }



}
