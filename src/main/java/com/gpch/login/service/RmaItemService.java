package com.gpch.login.service;

import com.gpch.login.model.rma.RmaItem;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RmaItemService {
    List<RmaItem> getAll();
    RmaItem getRmaItemById();
}
