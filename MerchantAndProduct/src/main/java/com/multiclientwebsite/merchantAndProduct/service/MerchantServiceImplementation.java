package com.multiclientwebsite.merchantAndProduct.service;

import com.multiclientwebsite.merchantAndProduct.entity.Merchant;
import com.multiclientwebsite.merchantAndProduct.exception.NoSuchMerchantExistsException;
import com.multiclientwebsite.merchantAndProduct.repository.MerchantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class MerchantServiceImplementation implements MerchantService{

    @Autowired
    MerchantRepository merchantRepository;

    @Override
    public Merchant addMerchant(Merchant merchant) {
        return merchantRepository.save(merchant);
    }

    @Override
    public Merchant getMerchant(Long merchantId) throws NoSuchMerchantExistsException {
        Optional<Merchant> foundMerchant = merchantRepository.findById(merchantId);
        if(foundMerchant.isPresent())
            return foundMerchant.get();
        else
            throw new NoSuchMerchantExistsException("Merchant with id "+ merchantId +" does not exist.");
    }

    @Override
    public String deleteMerchant(Long merchantId) throws NoSuchMerchantExistsException {
        Optional<Merchant> found = merchantRepository.findById(merchantId);
        try {
            if (found.isPresent()) {
                this.merchantRepository.delete(found.get());
            }
            else {
                throw new NoSuchMerchantExistsException("Merchant with id " + merchantId + " not found");
            }
        }
        catch(NoSuchMerchantExistsException e) {
            return e.getMessage();
        }
        return "Merchant with id " + merchantId + " has been deleted";
    }

    @Override
    public List<Merchant> getAllMerchants() {
        return merchantRepository.findAll();
    }

    @Override
    public String updateMerchant(Long merchantId, Merchant merchant) throws NoSuchMerchantExistsException {
        Optional<Merchant> foundMerchant = merchantRepository.findById(merchantId);
        try {
            if (foundMerchant.isPresent()) {
                foundMerchant.get().setMerchantName(merchant.getMerchantName());
                merchantRepository.save(foundMerchant.get());
            } else
                throw new NoSuchMerchantExistsException("Merchant with id " + merchantId + " not found.");
        }
        catch(NoSuchMerchantExistsException e) {
            return e.getMessage();
        }
        return  "Merchant with id "+ merchantId +" has been updated.";

    }

}
