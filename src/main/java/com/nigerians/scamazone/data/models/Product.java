package com.nigerians.scamazone.data.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table
public class Product {
    @Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    private String image;
    private double price;
//    @Enumerated(EnumType.STRING)
//    private Category category;
    private String category;
    private String brand;
    private int quantity;
}