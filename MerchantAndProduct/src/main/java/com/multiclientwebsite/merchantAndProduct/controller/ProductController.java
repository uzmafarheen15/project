package com.multiclientwebsite.merchantAndProduct.controller;


import com.multiclientwebsite.merchantAndProduct.entity.Merchant;
import com.multiclientwebsite.merchantAndProduct.entity.Product;
import com.multiclientwebsite.merchantAndProduct.exception.NoSuchMerchantExistsException;
import com.multiclientwebsite.merchantAndProduct.exception.NoSuchProductExistsException;
import com.multiclientwebsite.merchantAndProduct.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/")
    public Product addProductToMerchant(@RequestBody Product product){
        return productService.addProduct(product);
    }

    @GetMapping("/{productId}")
    public Product getProductWithMerchant(@PathVariable ("productId") Long productId) throws NoSuchProductExistsException {
        return productService.getProductWithMerchant(productId);
    }

    @PutMapping("/{productId}")
    public String updateProduct(@PathVariable("productId") Long productId, @RequestBody Product product) throws NoSuchProductExistsException{
        return productService.updateProduct(productId, product);
    }

    @DeleteMapping("/{productId}")
    public String deleteProduct(@PathVariable("productId") Long productId) throws NoSuchProductExistsException{
        return productService.deleteProduct(productId);
    }

    @GetMapping("/")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }


}
