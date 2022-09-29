package com.nigerians.scamazone.services;

import com.nigerians.scamazone.data.models.Store;
import com.nigerians.scamazone.data.respositories.StoreRepository;
import com.nigerians.scamazone.dtos.Requests.CreateStoreRequest;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreService implements iStoreService {
    @Autowired
    private StoreRepository repo;
    private ModelMapper mapper = new ModelMapper();

    @Override
    public void createStore(CreateStoreRequest req) {}
}
