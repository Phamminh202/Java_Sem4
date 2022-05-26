package com.t2010a.javashopping.model;

import com.t2010a.javashopping.entity.Product;
import com.t2010a.javashopping.entity.cart.CartItem;

import java.util.ArrayList;

public interface ShoppingCartModel {
    void add(Product product,int qty);
    void update(Product product,int qty);
    void remove(Product product);
    ArrayList<CartItem> getListItems();
}
