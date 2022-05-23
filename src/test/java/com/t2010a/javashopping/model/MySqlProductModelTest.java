package com.t2010a.javashopping.model;

import com.t2010a.javashopping.entity.Product;
import com.t2010a.javashopping.entity.myenum.ProductStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class MySqlProductModelTest {
    ProductModel model;

    @BeforeEach
    void setUp() {
        model = new MySqlProductModel();
    }

    @Test
    void findById() {
        System.out.println(model.findById("SP001").toString());
    }

    @Test
    void update() {
        Product product = model.findById("SP002");
        product.setName("UpdateName");
        product.setUpdatedAt(LocalDateTime.now());
        model.update("SP002",product);
        System.out.println(model.findById("SP002").toString());
    }

    @Test
    void delete() {
        model.delete("SP002");
        Product product = model.findById("SP002");
        assertEquals(null,product);
    }

    @Test
    void save() {
    }
}