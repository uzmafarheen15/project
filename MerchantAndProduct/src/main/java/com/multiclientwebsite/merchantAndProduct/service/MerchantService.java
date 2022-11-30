package com.multiclientwebsite.merchantAndProduct.service;

import com.multiclientwebsite.merchantAndProduct.entity.Merchant;
import com.multiclientwebsite.merchantAndProduct.exception.NoSuchMerchantExistsException;

import java.util.List;
import java.util.Set;


public interface MerchantService {
    Merchant addMerchant(Merchant merchant);

    Merchant getMerchant(Long merchantId) throws NoSuchMerchantExistsException;

    String updateMerchant(Long merchantId, Merchant merchant) throws NoSuchMerchantExistsException;

    String deleteMerchant(Long merchantId) throws NoSuchMerchantExistsException;

    List<Merchant> getAllMerchants();
}






