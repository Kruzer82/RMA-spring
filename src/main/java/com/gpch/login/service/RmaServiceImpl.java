package com.gpch.login.service;

import com.gpch.login.model.rma.Rma;

import com.gpch.login.repository.RmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service("rmaService")
public class RmaServiceImpl implements RmaService {

    @Autowired
    private RmaRepository rmaRepository;

    @Override
    public List<Rma> getAllRma() {
        return rmaRepository.findAll();
    }

    @Override
    public Rma getRmaById(long id) {
        return rmaRepository.findRmaById(id);
    }
    
}
