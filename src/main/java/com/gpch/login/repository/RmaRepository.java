package com.gpch.login.repository;

import com.gpch.login.model.Rma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//@Repository("rmaRepository")
    public interface RmaRepository extends JpaRepository<Rma, Long> {

    Rma findRmaById(long id);
}

