package com.nigerians.scamazone.services;

import com.nigerians.scamazone.data.models.Seller;
import com.nigerians.scamazone.data.models.Store;
import com.nigerians.scamazone.data.respositories.StoreRepository;
import com.nigerians.scamazone.dtos.Requests.CreateStoreRequest;
import com.nigerians.scamazone.dtos.Responses.CreateStoreResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreService implements iStoreService {
    @Autowired
    private StoreRepository repo;
    @Autowired
    private UserService userService;

    private ModelMapper mapper = new ModelMapper();

    @Override
    public CreateStoreResponse createStore(CreateStoreRequest req) {
        Seller validUser = (Seller) userService.getUser(Long.parseLong(req.getUserId()), "SELLER");

        if (validUser == null) {
            return new CreateStoreResponse("Invalid User", "FAILED", null);
        }

        validUser.setStore(new Store(req.getName(), req.getDescription(), req.getImage()));

        userService.saveUser(validUser);

        return new CreateStoreResponse("Store created successfully", "SUCCESS", String.valueOf(validUser.getId()));
    }
}
