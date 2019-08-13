package com.example.demo.services;

import com.example.demo.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> findAll();

    void save(Product product);

    void delete(Product product);

    void deleteById(Long id);
    void update(Product product, Long id);


}
