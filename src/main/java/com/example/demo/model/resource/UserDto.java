package com.example.demo.model.resource;

import java.io.Serializable;
import java.util.List;

public class UserDto implements Serializable {

private long id;
private String name;
private List<OrderDto> orders;

    public UserDto() {
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

    public List<OrderDto> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderDto> orders) {
        this.orders = orders;
    }
}
