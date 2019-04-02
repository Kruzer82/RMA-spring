package com.gpch.login.model;

import lombok.Data;


import javax.persistence.*;

@Data
@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        int id;
        String name;
        String person;
        String phoneNumber;
        String eMail;
    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.PERSIST)
    @JoinColumn(name="seller_id")
        Seller seller;
}
