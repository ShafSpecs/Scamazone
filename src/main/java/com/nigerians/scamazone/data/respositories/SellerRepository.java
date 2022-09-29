package com.nigerians.scamazone.data.respositories;

import com.nigerians.scamazone.data.models.Seller;
import com.nigerians.scamazone.data.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepository extends JpaRepository<Seller, Long> {
    User findSellerByEmailAndPassword(String email, String password);
    User findSellerByEmail(String email);
    User findSellerById(Long id);
}
