package com.multiclientwebsite.merchantAndProduct.controller;

import com.multiclientwebsite.merchantAndProduct.entity.Merchant;
import com.multiclientwebsite.merchantAndProduct.exception.NoSuchMerchantExistsException;
import com.multiclientwebsite.merchantAndProduct.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/merchants")
public class MerchantController {

    @Autowired
    MerchantService merchantService;

    @PostMapping("/")
    public Merchant addMerchant(@RequestBody Merchant merchant){
        return merchantService.addMerchant(merchant);
    }

    @GetMapping("/{merchantId}")
    public Merchant getMerchant(@PathVariable ("merchantId") Long merchantId) throws NoSuchMerchantExistsException {
        return merchantService.getMerchant(merchantId);
    }

    @PutMapping("/{merchantId}")
    public String updateMerchant(@PathVariable("merchantId") Long merchantId, @RequestBody Merchant merchant) throws NoSuchMerchantExistsException{
        return merchantService.updateMerchant(merchantId, merchant);
    }

    @DeleteMapping("/{merchantId}")
    public String deleteMerchant(@PathVariable("merchantId") Long merchantId) throws NoSuchMerchantExistsException{
        return merchantService.deleteMerchant(merchantId);
    }

    @GetMapping("/")
    public List<Merchant> getAllMerchants() {
        return merchantService.getAllMerchants();
    }

}
