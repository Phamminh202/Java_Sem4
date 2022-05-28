package com.t2010a.javashopping.model;

import com.github.javafaker.Faker;
import com.t2010a.javashopping.entity.Product;
import com.t2010a.javashopping.entity.ProductFilter;
import com.t2010a.javashopping.entity.myenum.ProductStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

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
        product.setColor_id(1);
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
    public int getRandomNumberUsingNextInt(int min,int max){
        Random random = new Random();
        return  random.nextInt(max-min) + min;
    }

    @Test
    void prepareDate() {
        Faker faker = new Faker();
        for (int i = 0; i < 100; i++) {
            Product product = new Product();
            if (i<50){
                product.setColor_id(1);
                product.setCategory_id(1);
            }else {
                product.setColor_id(2);
                product.setCategory_id(2);
            }
            product.setId("SP"+getRandomNumberUsingNextInt(100,200));
            product.setName(faker.name().title());
            product.setImage("https://gowell.vn/wp-content/uploads/2019/04/ghe-xoay-falio.jpg");
            product.setPrice(getRandomNumberUsingNextInt(500,1000)*1000);
            product.setQty(getRandomNumberUsingNextInt(0,99));
            product.setContent(faker.lorem().sentence());
            model.save(product);
        }
    }

    @Test
    void findAll() {
        ProductFilter filter = new ProductFilter();
        filter.setCategory_id(1);
        List<Product> list = this.model.findAll(filter);
        for (Product product: list){
            System.out.println(product.toString());
        }
    }
}