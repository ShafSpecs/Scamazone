package com.nigerians.scamazone.controllers;

import com.nigerians.scamazone.dtos.Requests.*;
import com.nigerians.scamazone.dtos.Responses.*;
import com.nigerians.scamazone.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register/buyer")
    public RegisterBuyerResponse register(@Valid @RequestBody RegisterBuyerRequest req) {
        return userService.registerBuyer(req);
    }

    @PostMapping("/login/buyer")
    public LoginBuyerResponse login(@Valid @RequestBody LoginBuyerRequest req) {
        return userService.loginBuyer(req);
    }

    @GetMapping("/get/buyer/{req}")
    public GetBuyerResponse get(@PathVariable String req) {
        return userService.getBuyer(req);
    }

    @PostMapping("/register/seller")
    public RegisterSellerResponse registerSeller(@Valid @RequestBody RegisterUserRequest userId) {
        return userService.registerSeller(userId);
    }

    @GetMapping("/get/seller/{req}")
    public GetSellerResponse getSeller(@PathVariable String req) {
        return userService.getSeller(req);
    }

    //todo: `/update/{ROLE}` & `/delete/{ROLE}`

    //todo: `/reset-password`
}
