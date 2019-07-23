package com.example.demo.Services;

import com.example.demo.model.Order;

import java.util.List;

public interface OrderService {

    List<Order> findAll();

    void save (Order order);

    void delete (Order order);

    void deleteById(long id);

}
