package com.nigerians.scamazone.data.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String name;
    private String description;
    private String image;
    @OneToOne(mappedBy = "store")
    private Buyer buyer;
    @ElementCollection
    private List<Product> product;
}