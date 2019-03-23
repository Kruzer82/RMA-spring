package com.gpch.login.service;

import com.gpch.login.model.Rma;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface RmaService {
    public List<Rma> getAllRma();
    public Rma getRmaById(long id);
}
