package com.gpch.login.controller;

import com.gpch.login.model.Seller;
import com.gpch.login.repository.SellerRepository;
import com.gpch.login.service.SellerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.ResultSet;
import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@SuppressWarnings("Duplicates")
@RestController
public class SellerController {

    @Autowired
    private SellerService sellerService;

    @Autowired
    protected SellerRepository sellerRepository;

    @GetMapping("/json/seller")
    List<Seller> getAllSeller(){
        return sellerService.findAllSeller();
    }

    @PostMapping("/json/seller")
    @ResponseBody
    ResponseEntity<Seller> addSeller(@Valid @ModelAttribute Seller seller){
        return sellerService.addNewSellerEnt(seller);



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

}
