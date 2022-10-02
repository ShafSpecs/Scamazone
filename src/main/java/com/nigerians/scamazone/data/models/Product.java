package com.nigerians.scamazone.data.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "PRODUCT")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    private String image;
    private double price;
//    @Enumerated(EnumType.STRING)
//    private Category category;
    private String category;
    private int quantity;
    @ManyToOne
    @JoinColumn(name="store_id", nullable=false)
    private Store store;
}