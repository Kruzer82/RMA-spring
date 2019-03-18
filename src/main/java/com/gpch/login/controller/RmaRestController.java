package com.gpch.login.controller;

import com.gpch.login.model.Rma;
import com.gpch.login.service.RmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RmaRestController {


    @Autowired
    private RmaService rmaService;

    @RequestMapping(path="/rmas", method=RequestMethod.GET)
    public List<Rma> getAllRma(){
        return rmaService.getAllRma();
    }

//    @RequestMapping(value = "/employee/{id}", method = RequestMethod.GET)
//    public Rma getEmployeeById(@PathVariable("id") long id){
//        return employeeService.getEmployeeById(id);
//    }

}