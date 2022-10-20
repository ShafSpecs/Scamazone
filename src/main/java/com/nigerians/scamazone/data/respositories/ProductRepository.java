package com.nigerians.scamazone.data.respositories;

import com.nigerians.scamazone.data.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    //get: For the homepage
//    List<Product> findAllByName(Sort sort);
    List<Product> findAllByCategory(String category);
    Page<Product> findAllByCategory(String category, Pageable pageable);
    List<Product> findAllByNameContaining(String query);
    Page<Product> findAllByNameContaining(String query, Pageable pageable);
    List<Product> findAllByPriceBetween(double min, double max);

    Page<Product> findAllByPriceBetween(double min, double max, Pageable pageable);
}