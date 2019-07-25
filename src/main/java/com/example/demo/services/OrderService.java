package com.example.demo.services;

import com.example.demo.model.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {

    List<Order> findAll();

    void save (Order order);

    void delete (Order order);

    void deleteById(long id);

    Optional<Order> findById(long orderId);
}
