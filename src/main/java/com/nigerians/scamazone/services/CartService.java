package com.nigerians.scamazone.services;

import com.nigerians.scamazone.data.models.Buyer;
import com.nigerians.scamazone.data.models.Cart;
import com.nigerians.scamazone.data.models.Item;
import com.nigerians.scamazone.data.models.Product;
import com.nigerians.scamazone.data.respositories.CartRepository;
import com.nigerians.scamazone.dtos.Requests.*;
import com.nigerians.scamazone.dtos.Responses.AddToCartResponse;
import com.nigerians.scamazone.dtos.Responses.ClearCartResponse;
import com.nigerians.scamazone.dtos.Responses.RemoveFromCartResponse;
import com.nigerians.scamazone.dtos.Responses.UpdateCartItemQuantityResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService implements iCartService {
    @Autowired
    private CartRepository repo;
    @Autowired
    private ProductService productService;
    @Autowired
    private UserService userService;

    @Override
    public Cart createCart() {
        Cart cart = new Cart();
        repo.save(cart);

        return cart;
    }

    @Override
    public AddToCartResponse addToCart(AddToCartRequest req) {
        Buyer buyer = (Buyer) userService.getUser(Long.parseLong(req.getUserId()), "BUYER");
        Product foundProduct = productService.getProductById(req.getProductId());

        Cart cart = buyer.getCart();

        if (cart == null) {
            cart = createCart();
        }

        Item newItem = new Item();
        newItem.setQuantity(1);
        newItem.setItemId(foundProduct.getId());
        newItem.setImage(foundProduct.getImage());
        newItem.setName(foundProduct.getName());
        newItem.setDescription(foundProduct.getDescription());
        newItem.setPrice(foundProduct.getPrice());

        cart.getItems().add(newItem);

        userService.saveUser(buyer);
        saveCart(cart);

        return new AddToCartResponse("Item added to cart successfully", "SUCCESS", buyer.getId().toString());
    }

    @Override
    public RemoveFromCartResponse removeFromCart(RemoveFromCartRequest req) {
        Buyer buyer = (Buyer) userService.getUser(Long.parseLong(req.getUserId()), "BUYER");
        Cart cart = buyer.getCart();

        if (cart == null) {
            return new RemoveFromCartResponse("Cart is empty", "FAILED", buyer.getId().toString());
        }

        Item foundItem = cart.getItems().stream().filter(item -> item.getItemId().toString().equals(req.getProductId().toString())).findFirst().orElse(null);

        if (foundItem == null) {
            return new RemoveFromCartResponse("Product isn't found", "FAILED", buyer.getId().toString());
        }

        cart.getItems().remove(foundItem);

        userService.saveUser(buyer);
        saveCart(cart);

        return new RemoveFromCartResponse("Item successfully added to cart", "SUCCESS", req.getUserId().toString());
    }

    @Override
    public ClearCartResponse clearCart(ClearCartRequest req) {
        Buyer buyer = (Buyer) userService.getUser(Long.parseLong(req.getUserId()), "BUYER");
        Cart cart = buyer.getCart();

        if (cart == null) {
            return new ClearCartResponse("Error whilst clearing cart, cart not found!", "FAILED", req.getUserId().toString());
        }

        cart.getItems().clear();

        userService.saveUser(buyer);
        saveCart(cart);

        return new ClearCartResponse("Cart cleared successfully", "SUCCESS", req.getUserId().toString());
    }

    @Override
    public UpdateCartItemQuantityResponse updateCartItemQuantity(UpdateCartItemQuantityRequest req) {
        Buyer buyer = (Buyer) userService.getUser(Long.parseLong(req.getUserId()), "BUYER");
        Cart cart = buyer.getCart();

        if (cart == null) {
            return new UpdateCartItemQuantityResponse("Error whilst updating cart item quantity, cart not found!", "FAILED", req.getUserId().toString());
        }

        Item foundItem = cart.getItems().stream().filter(item -> item.getItemId().toString().equals(req.getUserId().toString())).findFirst().orElse(null);

        if (foundItem == null) {
            return new UpdateCartItemQuantityResponse("Error whilst updating cart item quantity, item not found!", "FAILED", req.getUserId().toString());
        }

        foundItem.setQuantity(req.getQuantity());

        userService.saveUser(buyer);
        saveCart(cart);

        return new UpdateCartItemQuantityResponse("Cart item quantity updated successfully", "SUCCESS", req.getUserId().toString());
    }

    @Override
    public void saveCart(Cart userCart) {
        repo.save(userCart);
    }
}
