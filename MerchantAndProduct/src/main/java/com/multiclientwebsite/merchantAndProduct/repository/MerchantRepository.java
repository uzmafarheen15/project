package com.multiclientwebsite.merchantAndProduct.repository;

import com.multiclientwebsite.merchantAndProduct.entity.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MerchantRepository extends JpaRepository<Merchant, Long> {
}
