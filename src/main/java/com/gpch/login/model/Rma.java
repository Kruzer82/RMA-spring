package com.gpch.login.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "rma")
public class Rma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @GeneratedValue(strategy= GenerationType.AUTO)
        int id;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "id")
        List<RmaItem> rmaItems;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id", referencedColumnName = "id")
        Client client;
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "id", referencedColumnName = "id")
//    Users users;
        LocalDateTime registerDate;
        LocalDateTime updateDate;
        String Status;
        int Invoice;
        int SO;
        String trackingNumber;
        Boolean isDelete;


}
