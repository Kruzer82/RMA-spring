package com.gpch.login.controller;

import com.gpch.login.model.*;
import com.gpch.login.repository.ClientRepository;
import com.gpch.login.repository.RmaItemRepository;
import com.gpch.login.repository.RmaRepository;
import com.gpch.login.repository.UserRepository;
import com.gpch.login.service.ClientService;
import com.gpch.login.service.ClientServiceImpl;
import com.gpch.login.service.RmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("Duplicates")
@RestController
public class RmaRestController {

    private RmaService rmaService;
    private ClientService clientService;
    private RmaRepository rmaRepository;
    private ClientRepository clientRepository;
    private UserRepository userRepository;
    private RmaItemRepository rmaItemRepository;

    @Autowired
    public RmaRestController(RmaService rmaService, ClientService clientService, RmaRepository rmaRepository, ClientRepository clientRepository, UserRepository userRepository, RmaItemRepository rmaItemRepository) {
        this.rmaService = rmaService;
        this.clientService = clientService;
        this.rmaRepository = rmaRepository;
        this.clientRepository = clientRepository;
        this.userRepository = userRepository;
        this.rmaItemRepository = rmaItemRepository;

    }

    @RequestMapping(path="/json/rma", method=RequestMethod.GET)
    public List<Rma> getAllRma(Model model){
        model.addAttribute("client", new Client());
        model.addAttribute("rmaItem", new RmaItem());
        model.addAttribute("RmaItemRepository", rmaItemRepository);
        return rmaService.getAllRma();
    }


    @RequestMapping(value = "/json/rma", method = RequestMethod.POST)
    public Rma addRma(Authentication auth, @ModelAttribute("Rma") Rma rma, @ModelAttribute Client client) {
        UserDetails userDetails = (UserDetails) auth.getPrincipal();
        String username = userDetails.getUsername();

        rma.setClient(client);
//        rma.setRmaItems(rmaItems);
        rmaRepository.save(rma);
        return rma;
    }

    @RequestMapping(value = "/json/rma/{id}", method = RequestMethod.GET)
    public Rma getRmaById(@PathVariable("id") long id)
    {
        return rmaRepository.findById(id);
    }

    @RequestMapping(value = "/json/rma/{id}", method = RequestMethod.POST)
    public Rma updateRmaById(Authentication auth, @PathVariable("id") long id, @ModelAttribute("Rma") Rma rma){
        UserDetails userDetails = (UserDetails) auth.getPrincipal();
        String username = userDetails.getUsername();
        Rma rmafromdb = rmaRepository.findById(id);
        rmafromdb = rma;
        rmaRepository.save(rmafromdb);
        return rmaRepository.findById(id);
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



}