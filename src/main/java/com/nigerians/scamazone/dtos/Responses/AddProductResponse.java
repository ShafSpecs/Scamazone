package com.nigerians.scamazone.dtos.Responses;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddProductResponse {
    private String message;
    private String token;
    private String userId;
    private String productId;
}