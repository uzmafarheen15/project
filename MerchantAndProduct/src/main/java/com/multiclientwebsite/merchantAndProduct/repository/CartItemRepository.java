package com.multiclientwebsite.merchantAndProduct.repository;

import com.multiclientwebsite.merchantAndProduct.entity.Cart;

public interface CartItemRepository {
    void deleteById(Long cartItemId);

    void deleteAllByCart(Cart cart);
}
