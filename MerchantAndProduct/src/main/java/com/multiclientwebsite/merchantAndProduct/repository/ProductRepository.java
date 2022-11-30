package com.multiclientwebsite.merchantAndProduct.repository;

import com.multiclientwebsite.merchantAndProduct.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
