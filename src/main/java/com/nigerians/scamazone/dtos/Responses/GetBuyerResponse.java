package com.nigerians.scamazone.dtos.Responses;

import com.nigerians.scamazone.data.models.Cart;

public class GetBuyerResponse {
    public String message;
    public String token;
    public String userId;
    public String firstName;
    public String lastName;
    public String email;
    public String address;
    public Cart cart;

    public GetBuyerResponse(String message, String token, String userId, String firstName, String lastName, String email, String address, Cart cart) {
        this.message = message;
        this.token = token;
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.cart = cart;
    }
}
