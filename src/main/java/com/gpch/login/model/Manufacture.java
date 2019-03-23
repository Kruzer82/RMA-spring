package com.gpch.login.model;

import lombok.Data;
import javax.persistence.*;
import java.util.List;

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
