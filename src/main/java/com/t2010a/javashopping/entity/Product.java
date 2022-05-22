package com.t2010a.javashopping.entity;

import com.t2010a.javashopping.entity.base.BaseEntity;
import com.t2010a.javashopping.entity.myenum.ProductStatus;

import java.time.LocalDateTime;

public class Product extends BaseEntity {
    private String id;
    private String name;
    private String image;
    private double price;
    private int qty;
    private int color_id;
    private String content;
    private int category_id;
    private ProductStatus status;

    public Product() {
        this.id = "";
        this.name = "";
        this.image = "";
        this.content = "";
    }

    public Product(String id, String name, String image, double price, int qty, int color_id, String content, int category_id) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.price = price;
        this.qty = qty;
        this.color_id = color_id;
        this.content = content;
        this.category_id = category_id;
        this.status = ProductStatus.ACTIVE;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getColor_id() {
        return color_id;
    }

    public void setColor_id(int color_id) {
        this.color_id = color_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public ProductStatus getStatus() {
        return status;
    }

    public void setStatus(ProductStatus status) {
        this.status = status;
    }
}