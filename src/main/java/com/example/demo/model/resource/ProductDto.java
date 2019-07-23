package com.example.demo.model.resource;

import com.example.demo.model.Basket;

import java.io.Serializable;
import java.util.List;

public class ProductDto implements Serializable {
    private long id;
    private String name;
    private List<BasketDto> baskets;
public ProductDto (){
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

    public List<BasketDto> getBaskets() {
        return baskets;
    }

    public void setBaskets(List<BasketDto> baskets) {
        this.baskets = baskets;
    }
}
