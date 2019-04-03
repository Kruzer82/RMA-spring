package com.gpch.login.model.rma.rmaitem;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Type {
    @Id
    @GeneratedValue
        int id;
        String type;
//    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "type")
//        List<RmaItem> rmaItems;
}
