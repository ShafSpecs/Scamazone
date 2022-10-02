package com.nigerians.scamazone.controllers;

import com.nigerians.scamazone.dtos.Requests.CreateStoreRequest;
import com.nigerians.scamazone.dtos.Responses.CreateStoreResponse;
import com.nigerians.scamazone.services.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/stores")
public class StoreController {
    @Autowired
    private StoreService storeService;

    @PostMapping("/create-store")
    public CreateStoreResponse createStore(@Valid @RequestBody CreateStoreRequest req) {
        return storeService.createStore(req);
    }

    //todo: `/get-store`, `/update-store` & `/delete-store`
}
