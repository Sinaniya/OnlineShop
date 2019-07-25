package com.example.demo.model.resource;

import java.io.Serializable;
import java.util.List;

public class ProductDto implements Serializable {
    private long            id;
    private String          name;
    private List<Long> basketIds;
    private List<Long> orderIds;

    public ProductDto() {
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

    public List<Long> getBasketIds() {
        return basketIds;
    }

    public void setBasketIds(List<Long> basketIds) {
        this.basketIds = basketIds;
    }

    public List<Long> getOrderIds() {
        return orderIds;
    }

    public void setOrderIds(List<Long> orderIds) {
        this.orderIds = orderIds;
    }
}
