package com.nigerians.scamazone.controllers;

import com.nigerians.scamazone.dtos.Requests.AddToCartRequest;
import com.nigerians.scamazone.dtos.Requests.ClearCartRequest;
import com.nigerians.scamazone.dtos.Requests.RemoveFromCartRequest;
import com.nigerians.scamazone.dtos.Requests.UpdateCartItemQuantityRequest;
import com.nigerians.scamazone.dtos.Responses.AddToCartResponse;
import com.nigerians.scamazone.dtos.Responses.ClearCartResponse;
import com.nigerians.scamazone.dtos.Responses.RemoveFromCartResponse;
import com.nigerians.scamazone.dtos.Responses.UpdateCartItemQuantityResponse;
import com.nigerians.scamazone.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @PutMapping("/add")
    public AddToCartResponse addToCart(AddToCartRequest req) {
        return cartService.addToCart(req);
    }

    @PatchMapping("/remove")
    public RemoveFromCartResponse removeFromCart(RemoveFromCartRequest req) {
        return cartService.removeFromCart(req);
    }

    @DeleteMapping("/clear")
    public ClearCartResponse clearCart(ClearCartRequest req) {
        return cartService.clearCart(req);
    }

    @PatchMapping("/update")
    public UpdateCartItemQuantityResponse updateCartItemQuantity(UpdateCartItemQuantityRequest req) {
        return cartService.updateCartItemQuantity(req);
    }
}
