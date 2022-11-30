package com.multiclientwebsite.merchantAndProduct.repository;


import com.multiclientwebsite.merchantAndProduct.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {
}
