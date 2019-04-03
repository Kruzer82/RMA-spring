package com.gpch.login.model.rma.rmaitem;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Model {
    @Id
    @GeneratedValue
        int id;
        String model;
//    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "model")
//    List<RmaItem> rmaItems;
}
