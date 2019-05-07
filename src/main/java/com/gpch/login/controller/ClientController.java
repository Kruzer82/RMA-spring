package com.gpch.login.controller;

import com.gpch.login.model.rma.Client;
import com.gpch.login.model.rma.Seller;
import com.gpch.login.repository.ClientRepository;
import com.gpch.login.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@SuppressWarnings("Duplicates")

@RestController
public class ClientController {
    private ClientService clientService;
    private ClientRepository clientRepository;

    public ClientController(ClientService clientService, ClientRepository clientRepository) {
        this.clientService = clientService;
        this.clientRepository = clientRepository;
    }

    @GetMapping("/json/client")
    @ResponseBody
    ResponseEntity<List<Client>> getAllClient(){
        return clientService.getAllClient();
    }

    @GetMapping("/json/client/{id}")
    @ResponseBody
    ResponseEntity<Optional<Client>> getClientById(@PathVariable("id") Long id){
        return clientService.getClientById(id);
    }

    @PutMapping("/json/client/{id}")
    @ResponseBody
    ResponseEntity<Client> updateClientById(@PathVariable("id") Long id,@Valid @ModelAttribute Client client) {
        return clientService.updateClientById(id,client);
    }


}
