package com.nigerians.scamazone.data.models;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Data
@Entity
public class Buyer extends User {
    private Long buyerId;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "store_id", referencedColumnName = "id")
    private Store store;
}