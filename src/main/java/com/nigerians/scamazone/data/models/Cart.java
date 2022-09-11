package com.nigerians.scamazone.data.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cartId;
    private int quantity;
    private int total;
    @OneToOne(mappedBy = "cart")
    private Seller seller;
    @ElementCollection
    private List<Item> items;
}