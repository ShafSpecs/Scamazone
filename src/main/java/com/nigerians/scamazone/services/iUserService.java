package com.nigerians.scamazone.services;

import com.nigerians.scamazone.dtos.Requests.*;
import com.nigerians.scamazone.dtos.Responses.*;

public interface iUserService {
    RegisterBuyerResponse registerBuyer(RegisterBuyerRequest req);
    LoginBuyerResponse loginBuyer(LoginBuyerRequest req);
    GetBuyerResponse getBuyer(String req);
    RegisterSellerResponse registerSeller(RegisterUserRequest req);
    GetSellerResponse getSeller(String req);
    CreateStoreResponse createStore(CreateStoreRequest req);
}
