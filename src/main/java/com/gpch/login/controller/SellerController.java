package com.gpch.login.controller;

import com.gpch.login.model.rma.Seller;
import com.gpch.login.repository.SellerRepository;
import com.gpch.login.service.SellerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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
        return sellerService.findAllSeller();
    }

    @GetMapping("/json/seller/{id}")
    @ResponseBody
    ResponseEntity<Optional<Seller>> getSellerById(@PathVariable("id") Long id){
        return sellerService.findById(id);
    }

    @PutMapping("/json/seller/{id}")
    @ResponseBody
    ResponseEntity<Seller> updateSellerById(@PathVariable("id") Long id,@Valid @ModelAttribute Seller seller) {
        return sellerService.updateSellerById(id,seller);
    }

    @PostMapping("/json/seller")
    @ResponseBody
    ResponseEntity<Seller> addSeller(@Valid @ModelAttribute Seller seller, BindingResult bindingResult) {
        System.out.println(bindingResult.getAllErrors());
        return sellerService.addNewSellerEnt(seller);
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

