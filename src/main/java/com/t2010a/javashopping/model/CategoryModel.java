package com.t2010a.javashopping.model;

import com.t2010a.javashopping.entity.Category;

import java.util.List;

public interface CategoryModel {
    Category save(Category category);

    List<Category> findAll();

    Category findById(int id);

    Category update(int id,Category category);

    boolean delete(int id);
}
