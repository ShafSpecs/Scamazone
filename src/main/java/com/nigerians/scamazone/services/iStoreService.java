package com.nigerians.scamazone.services;

import com.nigerians.scamazone.dtos.Requests.CreateStoreRequest;
import com.nigerians.scamazone.dtos.Responses.CreateStoreResponse;

public interface iStoreService {
    CreateStoreResponse createStore(CreateStoreRequest req);
}
