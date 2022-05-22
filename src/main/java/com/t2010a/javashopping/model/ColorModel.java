package com.t2010a.javashopping.model;

import com.t2010a.javashopping.entity.Color;
import com.t2010a.javashopping.entity.Product;

import java.util.List;

public interface ColorModel {
    Color save(Color color);

    List<Color> findAll();

    Color findById(int id);

    Color update(int id,Color color);

    boolean delete(int id);
}
