package com.gpch.login.model.rma.rmaitem;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
public class Manufacture {
    @Id
    @GeneratedValue
        int id;
        String manufacture;
//    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "manufacture")
//    List<RmaItem> rmaItems;

}
