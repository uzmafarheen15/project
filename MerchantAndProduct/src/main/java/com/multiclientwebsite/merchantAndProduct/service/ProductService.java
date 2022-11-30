package com.multiclientwebsite.merchantAndProduct.service;

import com.multiclientwebsite.merchantAndProduct.entity.Merchant;
import com.multiclientwebsite.merchantAndProduct.entity.Product;
import com.multiclientwebsite.merchantAndProduct.exception.NoSuchProductExistsException;

import java.util.List;

public interface ProductService {
    Product addProduct(Product product);

    Product getProductWithMerchant(Long productId) throws NoSuchProductExistsException;


    String deleteProduct(Long productId) throws NoSuchProductExistsException;

    List<Product> getAllProducts();

    String updateProduct(Long productId, Product product) throws NoSuchProductExistsException;
}
