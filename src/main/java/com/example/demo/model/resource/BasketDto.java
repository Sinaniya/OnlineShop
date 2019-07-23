package com.example.demo.model.resource;

import java.io.Serializable;
import java.util.List;

public class BasketDto implements Serializable {
    private long id;
    private String name;
    private List<UserDto> users;
    private List<PaymentDto> payments;

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

    public List<UserDto> getUsers() {
        return users;
    }

    public void setUsers(List<UserDto> users) {
        this.users = users;
    }

    public List<PaymentDto> getPayments() {
        return payments;
    }

    public void setPayments(List<PaymentDto> payments) {
        this.payments = payments;
    }
}
