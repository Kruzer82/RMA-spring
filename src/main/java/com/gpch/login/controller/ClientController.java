package com.gpch.login.controller;

import com.gpch.login.model.rma.Client;
import com.gpch.login.model.rma.Seller;
import com.gpch.login.repository.ClientRepository;
import com.gpch.login.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@SuppressWarnings("Duplicates")

@RestController
public class ClientController {
    @Autowired
    private ClientService clientService;

    @Autowired
    private ClientRepository clientRepository;

    @GetMapping("/json/client")
    @ResponseBody
    ResponseEntity<List<Client>> getAllClient(){
        return clientService.getAllClient();
    }

    @PostMapping("/json/client")
    @ResponseBody
    ResponseEntity<Client> AddClient(@ModelAttribute Client client){
        System.out.println("--------------------------");
        System.out.println(client);
        System.out.println("--------------------------");
        return clientService.save(client);
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

    @GetMapping("/json/client/json")
    ResponseEntity<Client> showjsonclient() {
        Client client = new Client();
        Seller seller = new Seller();
        client.setSeller(seller);
        return new ResponseEntity<>(client, HttpStatus.OK);
    }


}
