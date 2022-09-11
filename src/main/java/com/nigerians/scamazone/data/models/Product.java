package com.nigerians.scamazone.data.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Embeddable
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String name;
    private String description;
    private String image;
    private String price;
    private int stock;
    private String storeId;
}