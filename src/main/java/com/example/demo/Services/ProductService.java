package com.example.demo.Services;

import com.example.demo.model.Product;

import java.util.List;

public interface ProductService {

      List<Product> findAll();
    void save (Product product);
    void delete (Product product);
    void deleteById(Long id);
}
