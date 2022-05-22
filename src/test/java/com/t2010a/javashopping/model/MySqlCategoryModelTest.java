package com.t2010a.javashopping.model;

import com.t2010a.javashopping.entity.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MySqlCategoryModelTest {
    private MySqlCategoryModel model;
    @BeforeEach
    void setUp() {
        model = new MySqlCategoryModel();
    }

    @Test
    public void create (){
        Category category = new Category();
        category.setName("Roomhold");
        model.save(category);
    }
}