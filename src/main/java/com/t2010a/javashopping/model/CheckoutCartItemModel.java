package com.t2010a.javashopping.model;

import com.t2010a.javashopping.entity.cart.CartItem;

import java.util.List;

public interface CheckoutCartItemModel {
    CartItem save(CartItem cartItem);

    List<CartItem> findAll();

    List<CartItem> findByShoppingCartId(int shoppingcartId);
}
