package com.example.demo.model.resource;

import java.io.Serializable;
import java.util.List;

public class OrderDto implements Serializable {
    private long id;
    private long userId;
    private List<PaymentDto> payments;
    private List<ProductDto> products;

    public OrderDto(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public List<PaymentDto> getPayments() {
        return payments;
    }

    public void setPayments(List<PaymentDto> payments) {
        this.payments = payments;
    }

    public List<ProductDto> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDto> products) {
        this.products = products;
    }
}
