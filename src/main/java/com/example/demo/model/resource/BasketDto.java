package com.example.demo.model.resource;

import java.io.Serializable;
import java.util.List;

public class BasketDto implements Serializable {
    private long             id;
    private String           name;
    private long             userId;
    private List<ProductDto> products;

    public BasketDto() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ProductDto> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDto> products) {
        this.products = products;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
