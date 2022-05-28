package com.t2010a.javashopping.model;


import com.t2010a.javashopping.entity.cart.ShoppingCart;

import java.util.List;

public interface CheckoutShoppingCartModel {
    ShoppingCart save(ShoppingCart shoppingCart);

    List<ShoppingCart> findAll();

    ShoppingCart findById(int id);
    boolean browse(int id);
}
