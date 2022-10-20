package com.nigerians.scamazone.data.respositories;

import com.nigerians.scamazone.data.models.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {}
