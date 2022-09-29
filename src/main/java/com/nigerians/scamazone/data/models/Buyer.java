package com.nigerians.scamazone.data.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Buyer extends User {
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "cart_id", referencedColumnName = "id")
    private Cart cart;

    public Buyer(String firstName, String lastName, String email, String password, String address) {
        super(firstName, lastName, email, password, address);
    }

    public Buyer() {
        super(null, null, null, null, null);
    }
}