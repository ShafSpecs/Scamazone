package com.nigerians.scamazone.services;

import com.nigerians.scamazone.data.models.Cart;
import com.nigerians.scamazone.dtos.Requests.*;
import com.nigerians.scamazone.dtos.Responses.AddToCartResponse;
import com.nigerians.scamazone.dtos.Responses.ClearCartResponse;
import com.nigerians.scamazone.dtos.Responses.RemoveFromCartResponse;
import com.nigerians.scamazone.dtos.Responses.UpdateCartItemQuantityResponse;

public interface iCartService {
    Cart createCart();
    AddToCartResponse addToCart(AddToCartRequest req);
    RemoveFromCartResponse removeFromCart(RemoveFromCartRequest req);
    ClearCartResponse clearCart(ClearCartRequest req);
    UpdateCartItemQuantityResponse updateCartItemQuantity(UpdateCartItemQuantityRequest req);

    void saveCart(Cart userCart);
}
