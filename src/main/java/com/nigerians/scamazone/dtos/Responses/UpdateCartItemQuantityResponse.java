package com.nigerians.scamazone.dtos.Responses;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UpdateCartItemQuantityResponse {
    public String message;
    public String token;
    public String userId;
}
