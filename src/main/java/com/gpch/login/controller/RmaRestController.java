package com.gpch.login.controller;

import com.gpch.login.model.Client;
import com.gpch.login.model.Model;
import com.gpch.login.model.Rma;
import com.gpch.login.model.Users;
import com.gpch.login.repository.ClientRepository;
import com.gpch.login.repository.RmaRepository;
import com.gpch.login.repository.UserRepository;
import com.gpch.login.service.ClientService;
import com.gpch.login.service.ClientServiceImpl;
import com.gpch.login.service.RmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RmaRestController {


//    @Autowired
    private RmaService rmaService;
//    @Autowired
    private ClientService clientService;

//    @Autowired
    private RmaRepository rmaRepository;
//    @Autowired
    private ClientRepository clientRepository;
//    @Autowired
    private UserRepository userRepository;
@Autowired
    public RmaRestController(RmaService rmaService, ClientService clientService, RmaRepository rmaRepository, ClientRepository clientRepository, UserRepository userRepository) {
        this.rmaService = rmaService;
        this.clientService = clientService;
        this.rmaRepository = rmaRepository;
        this.clientRepository = clientRepository;
        this.userRepository = userRepository;
    }

    @RequestMapping(path="/json/rma", method=RequestMethod.GET)
    public List<Rma> getAllRma(){
        return rmaService.getAllRma();
    }

    @RequestMapping(value = "/json/rma/{id}", method = RequestMethod.GET)
    public Rma getRmaById(@PathVariable("id") long id){
        return rmaService.getRmaById(id);
    }

    @RequestMapping(value = "/json/rma/{id}", method = RequestMethod.POST)
    public Rma updateRmaById(@PathVariable("id") long id, @ModelAttribute("Rma") Rma rma){
        Rma rmafromdb = rmaService.getRmaById(id);
        rmafromdb = rma;
        rmaRepository.save(rma);
        return rma;
    }


    @GetMapping(value = "/json/showClient")
    public List<Client> showClient(){
        return clientRepository.findAll();
    }

    @RequestMapping(value = "/json/client", method = RequestMethod.POST)
    public Client addClient(Authentication auth, @ModelAttribute("Client") Client client,@RequestParam(value = "initials") String initials){
        UserDetails userDetails = (UserDetails) auth.getPrincipal();
        String username = userDetails.getUsername();
        Users users = userRepository.findByInitials(initials);
        client.setUsers(users);
        clientRepository.save(client);
        return client;
    }

    @RequestMapping(value = "/json/client/{id}", method = RequestMethod.GET)
    public Client getClient(@PathVariable("id") long id, Authentication auth){
        UserDetails userDetails = (UserDetails) auth.getPrincipal();
        String username = userDetails.getUsername();
        Client clientfromdb = null;
        clientfromdb = clientRepository.getById((int) id);
        return clientfromdb;
    }

    @RequestMapping(value = "/json/client/{id}", method = RequestMethod.POST)
    public Client updClient(@PathVariable("id") long id, Authentication auth, @ModelAttribute("Client") Client client,@RequestParam(value = "initials") String initials){

        UserDetails userDetails = (UserDetails) auth.getPrincipal();
        String username = userDetails.getUsername();
        Client clientfromdb = clientRepository.getById((int) id);
        Users users = userRepository.findByInitials(initials);
        client.setUsers(users);
        clientRepository.save(client);
        return clientfromdb;
    }

    public Client save(long id, Authentication auth, Client client,String initials){
        UserDetails userDetails = (UserDetails) auth.getPrincipal();
        String username = userDetails.getUsername();
        Client clientfromdb = clientRepository.getById((int) id);
        Users users = userRepository.findByInitials(initials);
        client.setUsers(users);
        clientRepository.save(client);
        return clientfromdb;

    }


}