package com.spring.demo.repositories;

import com.spring.demo.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// Repositories:
// Place that save a lost of get data func (memory, file, database,...).
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByProductName(String productName);
    List<Product> findByYear(Integer year);
}
