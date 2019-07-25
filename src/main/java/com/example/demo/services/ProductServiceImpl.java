package com.example.demo.services;

import com.example.demo.repository.ProductRepository;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)

public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository repository;

    @Override
    public List<Product> findAll() {
        return repository.findAll();
    }

    @Transactional
    @Override
    public void save(Product product) {
        repository.save(product);
    }

    @Transactional
    @Override
    public void delete(Product product) {
        repository.deleteById(product.getId());
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        Product product = repository.findProductById(id).orElseThrow(() -> new ResourceNotFoundException("Resource Not Found!"));
        repository.deleteById(product.getId());

    }

}
