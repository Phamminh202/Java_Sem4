package com.t2010a.javashopping.entity;

import com.t2010a.javashopping.entity.base.BaseEntity;
import com.t2010a.javashopping.entity.myenum.CategoryStatus;
import com.t2010a.javashopping.entity.myenum.ColorStatus;

import java.time.LocalDateTime;

public class Color extends BaseEntity {
    private int id;
    private String name;
    private ColorStatus status;

    public Color() {
        this.setCreatedAt(LocalDateTime.now());
        this.setUpdatedAt(LocalDateTime.now());
        this.status = ColorStatus.ACTIVE;
    }

    public Color(int id, String name) {
        this.id = id;
        this.name = name;
        this.setCreatedAt(LocalDateTime.now());
        this.setUpdatedAt(LocalDateTime.now());
        this.status = ColorStatus.ACTIVE;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ColorStatus getStatus() {
        return status;
    }

    public void setStatus(ColorStatus status) {
        this.status = status;
    }
}
