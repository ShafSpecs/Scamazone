package com.nigerians.scamazone.dtos.Requests;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddToCartRequest {
    private String userId;
    private String productId;
}
