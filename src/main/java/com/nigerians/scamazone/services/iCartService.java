package com.nigerians.scamazone.services;

import com.nigerians.scamazone.data.models.Cart;

public interface iCartService {
    Cart createCart();
    void addToCart(Long userId, Long productId);
    void removeFromCart(Long userId, Long productId);
    void clearCart(Long userId);

    void saveCart(Cart userCart);
}
