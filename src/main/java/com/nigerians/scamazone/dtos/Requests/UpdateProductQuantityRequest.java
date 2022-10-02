package com.nigerians.scamazone.dtos.Requests;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UpdateProductQuantityRequest {
    private String userId;
    private String productId;
    private int quantity;
}