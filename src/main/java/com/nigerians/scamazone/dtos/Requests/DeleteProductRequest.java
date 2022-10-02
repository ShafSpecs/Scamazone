package com.nigerians.scamazone.dtos.Requests;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DeleteProductRequest {
    private String productId;
    private String userId;
}
