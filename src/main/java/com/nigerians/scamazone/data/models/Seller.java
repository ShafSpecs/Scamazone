package com.nigerians.scamazone.data.models;

import javax.persistence.*;

@Entity
public class Seller extends User {
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "store_id", referencedColumnName = "id")
    private Store store;

    public Seller() {
        super();
        this.store = null;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Store getStore() {
        return store;
    }
}