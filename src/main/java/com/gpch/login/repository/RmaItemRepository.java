package com.gpch.login.repository;

import com.gpch.login.model.rma.RmaItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RmaItemRepository extends JpaRepository<RmaItem,Long> {
    RmaItem getById(long id);
    List<RmaItem> findAll();
}
