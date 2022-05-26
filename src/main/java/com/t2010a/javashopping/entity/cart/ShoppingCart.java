package com.t2010a.javashopping.entity.cart;

import com.t2010a.javashopping.entity.Product;
import com.t2010a.javashopping.entity.base.BaseEntity;
import com.t2010a.javashopping.model.ShoppingCartModel;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

public class ShoppingCart extends BaseEntity implements ShoppingCartModel {
    private int id;
    private int userId;
    private String shipName;
    private String shipPhone;
    private String shipAddress;
    private String shipNote;
    private double totalPrice;
    private HashMap<String,CartItem> cartItems;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getShipName() {
        return shipName;
    }

    public void setShipName(String shipName) {
        this.shipName = shipName;
    }

    public String getShipPhone() {
        return shipPhone;
    }

    public void setShipPhone(String shipPhone) {
        this.shipPhone = shipPhone;
    }

    public String getShipAddress() {
        return shipAddress;
    }

    public void setShipAddress(String shipAddress) {
        this.shipAddress = shipAddress;
    }

    public String getShipNote() {
        return shipNote;
    }

    public void setShipNote(String shipNote) {
        this.shipNote = shipNote;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public HashMap<String, CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(HashMap<String, CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    @Override
    public void add(Product product, int qty) {
        if (cartItems.containsKey(product.getId())){
            CartItem cartItem = cartItems.get(product.getId());
            int updateQty = cartItem.getQty() + qty;
            update(product,updateQty);
        }else {
            update(product,qty);
        }
    }

    @Override
    public void update(Product product, int qty) {
        if (cartItems.containsKey(product.getId())){
            CartItem cartItem = cartItems.get(product.getId());
            cartItem.setQty(qty);
            cartItems.put(product.getId(),cartItem);
        } else {
            CartItem cartItem = new CartItem();
            cartItem.setProductId(product.getId());
            cartItem.setProductName(product.getName());
            cartItem.setProductImage(product.getImage());
            cartItem.setUnitPrice(product.getPrice());
            cartItem.setQty(qty);
            cartItem.setCreatedAt(LocalDateTime.now());
            cartItems.put(product.getId(),cartItem);
        }
    }

    @Override
    public void remove(Product product) {
        if (cartItems.containsKey(product.getId())){
            cartItems.remove(product.getId());
        }
    }

    @Override
    public ArrayList<CartItem> getListItems() {
        return new ArrayList<>(cartItems.values());
    }
}
