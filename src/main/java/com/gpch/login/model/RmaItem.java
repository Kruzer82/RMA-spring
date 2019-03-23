package com.gpch.login.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class RmaItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @GeneratedValue(strategy= GenerationType.AUTO)
        int id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "type_id", referencedColumnName = "id")
        Type type;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "manufacture_id", referencedColumnName = "id")
        Manufacture manufacture;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "model_id", referencedColumnName = "id")
        Model model;
        String serialNumber;
   // @ManyToOne()
   // @JoinColumn(name = "rma_id")
   // Rma rma;
}
