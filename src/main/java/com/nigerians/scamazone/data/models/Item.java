package com.nigerians.scamazone.data.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Embeddable
public class Item {
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long itemId;
    private String name;
    private String description;
    private double price;
    private int quantity;
    private String image;
}