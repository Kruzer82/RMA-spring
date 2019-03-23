package com.gpch.login.service;

import com.gpch.login.model.Client;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface ClientService {
    public List<Client> getAllClient();
    public Client getClientById(long id);
}
