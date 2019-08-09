package com.example.demo.services;

import com.example.demo.repository.ProductRepository;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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

        Optional <Product> targetProduct=repository.findProductByName(product.getName());
        if(!targetProduct.isPresent()){
            repository.save(product);
            return;
        }
        throw new RuntimeException("product already exists");
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
    @Transactional
    @Override
    public void update(Product product , long id){

       if(repository.findProductById(id).isPresent()){
           Optional <Product> UpdatedProduct;
           UpdateProduct.setName(repository.findProductById(id).getName());


       }



}
}
