package com.t2010a.javashopping.model;

import com.t2010a.javashopping.entity.Product;
import com.t2010a.javashopping.entity.ProductFilter;

import java.util.List;

public interface ProductModel {
    Product save(Product product);

    List<Product> findAll();
    List<Product> findAll(ProductFilter filter);

    Product findById(String id);

    Product update(String id,Product product);

    boolean delete(String id);
}
