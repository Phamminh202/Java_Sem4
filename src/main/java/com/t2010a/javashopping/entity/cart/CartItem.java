package com.t2010a.javashopping.entity.cart;

import com.t2010a.javashopping.entity.base.BaseEntity;
import com.t2010a.javashopping.entity.myenum.CartItemStatus;

public class CartItem extends BaseEntity{
    private int shoppingcartId;
    private String productId;
    private String productName;
    private String productImage;
    private double unitPrice;
    private int qty;

    public CartItem() {
    }

    public int getShoppingcartId() {
        return shoppingcartId;
    }

    public void setShoppingcartId(int shoppingcartId) {
        this.shoppingcartId = shoppingcartId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
}
