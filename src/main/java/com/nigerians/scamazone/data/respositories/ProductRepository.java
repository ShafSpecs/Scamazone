package com.nigerians.scamazone.data.respositories;

import com.nigerians.scamazone.data.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    //get: For the homepage
//    List<Product> findAllByName(Sort sort);
    Page<Product> findAllByCategory(String category, Pageable pageable);
    Page<Product> findAllByNameContaining(String query, Pageable pageable);

    Page<Product> findAllByPriceBetween(double min, double max, Pageable pageable);
}