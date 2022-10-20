package com.nigerians.scamazone.data.respositories;

import com.nigerians.scamazone.data.models.Buyer;
import com.nigerians.scamazone.data.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuyerRepository extends JpaRepository<Buyer, Long> {
    User findBuyerByEmailAndPassword(String email, String password);
    User findBuyerByEmail(String email);
    User findBuyerById(Long id);
}