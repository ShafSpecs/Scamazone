package com.nigerians.scamazone.dtos.Requests;

import lombok.Data;

@Data
public class LoginSellerRequest {
    private String sellerId;
    private String email;
}
