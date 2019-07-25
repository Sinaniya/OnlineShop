package com.example.demo.services;

import com.example.demo.model.Order;
import com.example.demo.model.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    List<User> filterByName(String name);

    void save (User user);

    void delete (User user);

    void deleteByName(String name);

    void deleteById(long id);

    void addOrder(long userId,Order order);

    void removeOrder(long userId, Order order);
}
