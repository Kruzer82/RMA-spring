package com.gpch.login.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

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
