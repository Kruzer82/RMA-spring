package com.gpch.login.model.rma;

import com.gpch.login.enums.Status;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "rma")
public class Rma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "id")
    List<RmaItem> rmaItems;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id")
    Client client;
    LocalDateTime registerDate;
    LocalDateTime updateDate;
    @Enumerated(EnumType.STRING)
    Status status;
    @Pattern(regexp = "^[0-9]*$")
    int Invoice;
    @Pattern(regexp = "^[0-9]*$")
    int SO;
    String trackingNumber;
    Boolean isDelete;


}
