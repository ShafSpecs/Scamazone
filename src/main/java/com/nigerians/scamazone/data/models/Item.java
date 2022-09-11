package com.nigerians.scamazone.data.models;

import javax.persistence.Embeddable;
import javax.persistence.Id;

@Embeddable
public class Item {
    @Id
    private Long itemId;
    private String name;
    private String description;
    private int price;
    private int quantity;
    private String image;
    private String storeId;
}