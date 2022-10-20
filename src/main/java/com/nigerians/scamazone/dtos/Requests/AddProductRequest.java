package com.nigerians.scamazone.dtos.Requests;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddProductRequest {
    private String name;
    private String description;
    private String image;
    private Long price;
    private Integer quantity;
    private String userId;
    private String category;
}
