package com.multiclientwebsite.merchantAndProduct.service;


import com.multiclientwebsite.merchantAndProduct.entity.Cart;
import com.multiclientwebsite.merchantAndProduct.exception.InvalidCartItemDataException;
import com.multiclientwebsite.merchantAndProduct.exception.NoSuchCartItemExistsException;
import com.multiclientwebsite.merchantAndProduct.exception.NoSuchCartExistsException;

public interface CartService {

    public Cart getCartById(Long cartId) throws NoSuchCartExistsException;

    public Cart addToCart(Long cartId, Long dishId) throws NoSuchCartExistsException, InvalidCartItemDataException;

    public Cart increaseQuantity(Long cartId, Long cartItemId) throws NoSuchCartExistsException, NoSuchCartItemExistsException, InvalidCartItemDataException;

    public Cart removeFromCart(Long cartId, Long cartItemId) throws NoSuchCartExistsException, NoSuchCartItemExistsException;

    public Cart removeAllFromCart(Long cartId) throws NoSuchCartExistsException;

}
