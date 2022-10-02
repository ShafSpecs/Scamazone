package com.nigerians.scamazone.dtos.Requests;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RemoveFromCartRequest {
    private String userId;
    private String productId;
}
