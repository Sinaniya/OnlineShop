package com.example.demo.services;

import com.example.demo.model.Basket;

import java.util.List;

public interface BasketService {

    List<Basket> findAll();

    List<Basket> filterByName(String name);

    void save(Basket basket);

    void delete(Basket basket);

    void deleteByName(String name);

    void deleteById(Long id);
}
