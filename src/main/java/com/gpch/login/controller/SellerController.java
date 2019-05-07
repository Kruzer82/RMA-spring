package com.gpch.login.controller;

import com.gpch.login.model.rma.Seller;
import com.gpch.login.repository.SellerRepository;
import com.gpch.login.service.SellerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RestController;


@SuppressWarnings("Duplicates")
@RestController
public class SellerController {

    @Autowired
    private SellerService sellerService;

    @Autowired
    protected SellerRepository sellerRepository;


    @GetMapping("/json/seller")
    @ResponseBody
    ResponseEntity<List<Seller>> getAllSeller(){
        List<Seller> seller = sellerService.findAllSeller();
        if(seller.isEmpty()){
            return new ResponseEntity<List<Seller>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Seller>>(seller, HttpStatus.OK);
    }

    @GetMapping("/json/seller/{id}")
    @ResponseBody
    ResponseEntity<Seller> getSellerById(@PathVariable("id") Long id)
    {
        System.out.println("Fetching User with id " + id);
        Seller seller = sellerService.findById(id);
        if (seller == null) {
            System.out.println("User with id " + id + " not found");
            return new ResponseEntity<Seller>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Seller>(seller, HttpStatus.OK);
    }

    @PostMapping("/json/seller")
    @ResponseBody
    ResponseEntity<Void> addSeller(@RequestBody Seller seller, UriComponentsBuilder ucBuilder) {

        System.out.println("Creating User " + seller.getName());
        if (sellerService.isSellerExist(seller)) {
            System.out.println("A User with name " + seller.getName() + " already exist");
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        sellerService.addNewSellerEnt(seller);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(seller.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @PutMapping("/json/seller/{id}")
    @ResponseBody
    ResponseEntity<Seller> updateSellerById(@PathVariable("id") Long id,@Valid @ModelAttribute Seller seller) {
        System.out.println("Updating User " + id);

        Seller currentSeller = sellerService.findById(id);

        if (currentSeller==null) {
            System.out.println("User with id " + id + " not found");
            return new ResponseEntity<Seller>(HttpStatus.NOT_FOUND);
        }

        if (sellerService.isSellerExist(seller)) {
            System.out.println("User with name " + seller.getName() + " or initials" + seller.getInitials() + " already exist");
            return new ResponseEntity<Seller>(HttpStatus.ALREADY_REPORTED);
        }

        currentSeller.setName(seller.getName());
        currentSeller.setInitials(seller.getInitials());

        sellerService.updateSeller(currentSeller);
        return new ResponseEntity<Seller>(currentSeller, HttpStatus.OK);
    }
//        Seller sellerExists = sellerRepository.findByName(seller.getName());
//        if (sellerExists != null) {
//            bindingResult
//                    .rejectValue("name", "error.users",
//                            "There is already a users registered with the email provided");
//        }
//        if (bindingResult.hasErrors()) {
//            System.out.println("-------------------------------------\nERROR");
//        } else {
//            return new ResponseEntity<>(
//                    sellerRepository.save(seller),
//                    HttpStatus.OK);
//        }
//        return new ResponseEntity<>(
//                seller,
//                HttpStatus.BAD_REQUEST);

}

