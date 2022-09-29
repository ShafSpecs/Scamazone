package com.nigerians.scamazone.dtos.Responses;

import com.nigerians.scamazone.data.models.Store;
import lombok.Data;

public class GetSellerResponse {
    public String message;
    public String token;
    public String userId;
    public String firstName;
    public String lastName;
    public String email;
    public Store store;

    public GetSellerResponse(String message, String token, String userId, String firstName, String lastName, String email, Store store) {
        this.message = message;
        this.token = token;
        this.userId = userId;
        this.store = store;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
}
