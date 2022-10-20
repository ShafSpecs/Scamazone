package com.nigerians.scamazone.data.respositories;

import com.nigerians.scamazone.data.models.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {}