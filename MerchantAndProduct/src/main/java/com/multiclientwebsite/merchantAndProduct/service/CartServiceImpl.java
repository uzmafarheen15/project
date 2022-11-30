package com.multiclientwebsite.merchantAndProduct.service;


import com.multiclientwebsite.merchantAndProduct.entity.Cart;
import com.multiclientwebsite.merchantAndProduct.entity.CartItem;
import com.multiclientwebsite.merchantAndProduct.entity.Product;
import com.multiclientwebsite.merchantAndProduct.exception.InvalidCartItemDataException;
import com.multiclientwebsite.merchantAndProduct.exception.NoSuchCartExistsException;
import com.multiclientwebsite.merchantAndProduct.exception.NoSuchCartItemExistsException;
import com.multiclientwebsite.merchantAndProduct.repository.CartItemRepository;
import com.multiclientwebsite.merchantAndProduct.repository.CartRepository;
import com.multiclientwebsite.merchantAndProduct.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Cart getCartById(Long cartId) throws NoSuchCartExistsException {
        try {
            return cartRepository.findById(cartId).get();
        } catch (Exception e) {
            throw new NoSuchCartExistsException("Cart id does not exists");
        }
    }

    @Override
    public Cart addToCart(Long cartId, Long productId) throws NoSuchCartExistsException, InvalidCartItemDataException {
        Cart cart;
        try {
            cart = cartRepository.findById(cartId).get();
        } catch (Exception e) {
            throw new NoSuchCartExistsException("Cart id does not exists");
        }
        Product product = productRepository.findById(productId).get();
        List<CartItem> cartItems = cart.getCartItems();

        try {
            for (CartItem cI : cartItems) {
                if (cI.getCartItemName().equals(product.getProductName())) {
                    cI.setCartItemQuantity(cI.getCartItemQuantity() + 1);
                    cart.setCartItems(cartItems);
                    cart.setTotalAmount(cart.getTotalAmount() + cI.getCartItemPrice());
                    return cartRepository.save(cart);
                }
            }

            CartItem cartItem = new CartItem();
            cartItem.setCartItemName(product.getProductName());
            cartItem.setCartItemType(product.getProductType());
            cartItem.setCartItemDescription(product.getProductDescription());
//            cartItem.setCartItemImage(product.getProductImage());
            cartItem.setCartItemPrice(product.getProductPrice());
            cartItem.setCartItemQuantity(1);
            cartItem.setCart(cart);

            cartItems.add(cartItem);
            cart.setCartItems(cartItems);
            cart.setTotalAmount(cart.getTotalAmount() + cartItem.getCartItemPrice());
            return cartRepository.save(cart);
        } catch (Exception e) {
            throw new InvalidCartItemDataException("Enter correct cart item data");
        }
    }

    @Override
    public Cart increaseQuantity(Long cartId, Long cartItemId) throws NoSuchCartExistsException, NoSuchCartItemExistsException, InvalidCartItemDataException {
        Cart cart;
        try {
            cart = cartRepository.findById(cartId).get();
        } catch (Exception e) {
            throw new NoSuchCartExistsException("Cart id does not exists");
        }
        List<CartItem> cartItems = cart.getCartItems();
        try {
            for (CartItem cI : cartItems) {
                if (cI.getCartItemId() == cartItemId) {
                    cart.setTotalAmount(cart.getTotalAmount() + cI.getCartItemPrice());
                    cI.setCartItemQuantity(cI.getCartItemQuantity() + 1);
                    break;
                }
            }
        } catch (Exception e) {
            throw new NoSuchCartItemExistsException("Cart item does not exists");
        }
        cart.setCartItems(cartItems);
        return cartRepository.save(cart);
    }

    @Override
    public Cart removeFromCart(Long cartId, Long cartItemId) throws NoSuchCartExistsException, NoSuchCartItemExistsException {
        Cart cart;
        try {
            cart = cartRepository.findById(cartId).get();
        } catch (Exception e) {
            throw new NoSuchCartExistsException("Cart id does not exists");
        }
        List<CartItem> cartItems = cart.getCartItems();
        try {
            for (CartItem cI : cartItems) {
                if ((cI.getCartItemId() == cartItemId) && (cI.getCartItemQuantity() == 1)) {
                    cart.setTotalAmount(cart.getTotalAmount() - cI.getCartItemPrice());
                    cartItems.remove(cI);
                    cartItemRepository.deleteById(cartItemId);
                    break;
                }
                if ((cI.getCartItemId() == cartItemId) && (cI.getCartItemQuantity() > 1)) {
                    cart.setTotalAmount(cart.getTotalAmount() - cI.getCartItemPrice());
                    cI.setCartItemQuantity(cI.getCartItemQuantity() - 1);
                    break;
                }
            }
        } catch (Exception e) {
            throw new NoSuchCartItemExistsException("Cart item does not exists");
        }
        cart.setCartItems(cartItems);
        return cartRepository.save(cart);
    }

    @Override
    @Transactional
    public Cart removeAllFromCart(Long cartId) throws NoSuchCartExistsException {
        try {
            Cart cart = cartRepository.findById(cartId).get();
            List<CartItem> cartItems = cart.getCartItems();
            cartItems.clear();
            cart.setCartItems(cartItems);
            cart.setTotalAmount(0.0);
            cartItemRepository.deleteAllByCart(cart);
            return cartRepository.save(cart);
        } catch (Exception e) {
            throw new NoSuchCartExistsException("Cart id does not exists");
        }
    }

}

















