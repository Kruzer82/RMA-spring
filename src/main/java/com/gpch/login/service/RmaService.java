package com.gpch.login.service;

import com.gpch.login.model.Rma;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RmaService {
    public List<Rma> getAllRma();
    public Rma getRmaById(long id);
}
