package com.nigerians.scamazone.dtos.Requests;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UpdateProductRequest {
    private String name;
    private String description;
    private String image;
    private double price;
    private int quantity;
    private String category;
    private String productId;
    private String userId;
}
