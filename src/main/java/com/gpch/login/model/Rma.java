package com.gpch.login.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Rma {



    @Id
    @GeneratedValue
    @Column(name="id")
    private long id;
    @Column(name="name")
    private String name;
    @Column(name="last_name")
    private String lastName;
    @Column(name="email")
    private String email;
    @Column(name="phone")
    private String phone;
    @Column(name="active")
    private boolean active;

    public Rma() {
        super();
    }

    public Rma(String name, String lastName, String email, String phone, boolean active) {
        super();
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.active = active;
    }
}
