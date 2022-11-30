package com.multiclientwebsite.merchantAndProduct.controller;


import com.multiclientwebsite.merchantAndProduct.entity.Cart;
import com.multiclientwebsite.merchantAndProduct.exception.InvalidCartItemDataException;
import com.multiclientwebsite.merchantAndProduct.exception.NoSuchCartExistsException;
import com.multiclientwebsite.merchantAndProduct.exception.NoSuchCartItemExistsException;
import com.multiclientwebsite.merchantAndProduct.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(value = "http://localhost:4200/")
@RestController
@RequestMapping("/api/v1/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping("/{cartId}")
    public ResponseEntity<Cart> getCartById(@PathVariable("cartId") Long cartId) throws NoSuchCartExistsException {
        Cart cart = cartService.getCartById(cartId);
        return ResponseEntity.ok(cart);
    }

    @PostMapping("addToCart/{cartId}/{dishId}")
    public ResponseEntity<Cart> addToCart(@PathVariable("cartId") Long cartId, @PathVariable("dishId") Long dishId) throws NoSuchCartExistsException, InvalidCartItemDataException {
        Cart cart = cartService.addToCart(cartId, dishId);
        return ResponseEntity.ok(cart);
    }

    @PostMapping("/{cartId}/{cartItemId}")
    public ResponseEntity<Cart> increaseQuantity(@PathVariable("cartId") Long cartId, @PathVariable("cartItemId") Long cartItemId) throws InvalidCartItemDataException, NoSuchCartExistsException, NoSuchCartItemExistsException, NoSuchCartExistsException {
        Cart cart=cartService.increaseQuantity(cartId,cartItemId);
        return ResponseEntity.ok(cart);
    }

    @DeleteMapping("/{cartId}/{cartItemId}")
    public ResponseEntity<Cart> removeFromCart(@PathVariable("cartId") Long cartId, @PathVariable("cartItemId") Long cartItemId) throws NoSuchCartExistsException, NoSuchCartItemExistsException {
        Cart cart = cartService.removeFromCart(cartId, cartItemId);
        return ResponseEntity.ok(cart);
    }

    @DeleteMapping("/{cartId}")
    public ResponseEntity<Cart> removeAllFromCart(@PathVariable("cartId") Long cartId) throws NoSuchCartExistsException {
        Cart cart = cartService.removeAllFromCart(cartId);
        return ResponseEntity.ok(cart);
    }

}






