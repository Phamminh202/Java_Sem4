package com.t2010a.javashopping.model;

import com.t2010a.javashopping.entity.cart.CartItem;

import java.util.List;

public interface CheckoutCartItemModel {
    CartItem save(CartItem cartItem);

    List<CartItem> findAll();

    CartItem findByShoppingCartId(int shoppingcartId);
}
