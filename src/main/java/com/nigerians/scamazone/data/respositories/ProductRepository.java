package com.nigerians.scamazone.data.respositories;

import com.nigerians.scamazone.data.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {}