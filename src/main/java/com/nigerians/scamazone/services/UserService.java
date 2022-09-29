package com.nigerians.scamazone.services;

import com.google.common.hash.Hashing;
import com.nigerians.scamazone.data.models.*;
import com.nigerians.scamazone.data.respositories.BuyerRepository;
import com.nigerians.scamazone.data.respositories.SellerRepository;
import com.nigerians.scamazone.dtos.Requests.*;
import com.nigerians.scamazone.dtos.Responses.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.UUID;
import java.util.regex.Pattern;

@Service
public class UserService implements iUserService {
    @Autowired
    private BuyerRepository buyerRepo;
    @Autowired
    private SellerRepository sellerRepo;
    @Autowired
    private CartService cartService;

    @Override
    public RegisterBuyerResponse registerBuyer(RegisterBuyerRequest req) {
        ModelMapper mapper = new ModelMapper();
        Pattern passwordPattern = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=-_])(?=\\S+$).{8,}$");

        if (!passwordPattern.matcher(req.getPassword()).matches()) {
            return new RegisterBuyerResponse("Password must be at least 8 characters long, contain at least one uppercase letter, one lowercase letter, one number and one special character", "FAILED", null);
        }

        String hashedPassword = Hashing.sha256()
                .hashString(req.getPassword(), StandardCharsets.UTF_8)
                .toString();

        req.setPassword(hashedPassword);

        long uuid = UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;

        Buyer buyer = mapper.map(req, Buyer.class);
        buyer.setId(uuid);

        Cart userCart = cartService.createCart();
        buyer.setCart(userCart);

        buyerRepo.save(buyer);

        return new RegisterBuyerResponse("Buyer registered successfully", "SUCCESS", String.valueOf(uuid));
    }

    @Override
    public LoginBuyerResponse loginBuyer(LoginBuyerRequest req) {
        User validUser = buyerRepo.findBuyerByEmail(req.getEmail());

        if (validUser == null) {
            return new LoginBuyerResponse("Invalid Email", "FAILED", null);
        }

        String hashedPassword = Hashing.sha256()
                .hashString(req.getPassword(), StandardCharsets.UTF_8)
                .toString();

        req.setPassword(hashedPassword);

        validUser = buyerRepo.findBuyerByEmailAndPassword(req.getEmail(), req.getPassword());

        if (validUser == null) {
            return new LoginBuyerResponse("Invalid Password", "FAILED", null);
        }

        return new LoginBuyerResponse("Login successful", "SUCCESS", String.valueOf(validUser.getId()));
    }

    @Override
    public GetBuyerResponse getBuyer(String req) {
        Buyer buyer = (Buyer) buyerRepo.findBuyerById(Long.parseLong(req));

        return new GetBuyerResponse("Buyer retrieved successfully", "SUCCESS", String.valueOf(buyer.getId()), buyer.getFirstName(), buyer.getLastName(), buyer.getEmail(), buyer.getAddress(), buyer.getCart());
    }

    @Override
    public RegisterSellerResponse registerSeller(RegisterUserRequest req) {
        System.out.println(req.getUserId());
        Buyer user = (Buyer) buyerRepo.findBuyerById(Long.parseLong(req.getUserId()));

        Seller newSeller = new Seller();
        newSeller.setId(user.getId());
        newSeller.setFirstName(user.getFirstName());
        newSeller.setLastName(user.getLastName());
        newSeller.setEmail(user.getEmail());
        newSeller.setPassword(user.getPassword());
        newSeller.setAddress(user.getAddress());

        sellerRepo.save(newSeller);

        return new RegisterSellerResponse("Seller registered successfully", "SUCCESS", String.valueOf(newSeller.getId()));
    }

    @Override
    public GetSellerResponse getSeller(String req) {
        Seller seller = (Seller) sellerRepo.findSellerById(Long.parseLong(req));

        if (seller == null) {
            return new GetSellerResponse("Seller not found", "FAILED", null, null, null, null, null);
        }

        return new GetSellerResponse("Seller found", "SUCCESS", String.valueOf(seller.getId()), seller.getFirstName(), seller.getLastName(), seller.getEmail(), seller.getStore());
    }

    @Override
    public CreateStoreResponse createStore(CreateStoreRequest req) {
        Seller validUser = (Seller) sellerRepo.findSellerById(Long.parseLong(req.getUserId()));

        if (validUser == null) {
            return new CreateStoreResponse("Invalid User", "FAILED", null);
        }

        validUser.setStore(new Store(req.getName(), req.getDescription(), req.getImage()));

        sellerRepo.save(validUser);
        return new CreateStoreResponse("Store created successfully", "SUCCESS", String.valueOf(validUser.getId()));
    }
}
