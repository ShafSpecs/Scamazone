package com.nigerians.scamazone.services;

import com.nigerians.scamazone.data.models.User;
import com.nigerians.scamazone.dtos.Requests.*;
import com.nigerians.scamazone.dtos.Responses.*;

public interface iUserService {
    RegisterBuyerResponse registerBuyer(RegisterBuyerRequest req);
    LoginBuyerResponse loginBuyer(LoginBuyerRequest req);
    GetBuyerResponse getBuyer(String req);
    RegisterSellerResponse registerSeller(RegisterSellerRequest req);
    GetSellerResponse getSeller(String req);
    User getUser(Long userId, String role);
    void saveUser(User user);
}
