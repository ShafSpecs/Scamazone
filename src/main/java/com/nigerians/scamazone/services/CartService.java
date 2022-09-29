package com.nigerians.scamazone.services;

import com.nigerians.scamazone.data.models.Cart;
import com.nigerians.scamazone.data.respositories.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService implements iCartService {
    @Autowired
    private CartRepository repo;

    @Override
    public Cart createCart() {
        Cart cart = new Cart();
        System.out.println(cart);
        repo.save(cart);

        return cart;
    }

    @Override
    public void addToCart(Long userId, Long productId) {

    }

    @Override
    public void removeFromCart(Long userId, Long productId) {

    }

    @Override
    public void clearCart(Long userId) {

    }

    @Override
    public void saveCart(Cart userCart) {
        repo.save(userCart);
    }
}
