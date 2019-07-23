package com.example.demo.Services;

import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.Repository.ProductRepository;
import com.example.demo.model.Product;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)

public class ProductServiceImpl implements ProductService{

    @Override
  private ProductRepository repository;

    @Override
    public List<Product> findAll() {return repository.findAll();}

    @Transactional
    @Override
    public void delete (Product product){repository.deleteById(product.getProductId());}

    @Transactional
    @Override
    public void deleteById(Long id){
        Product product = repository.findProductById(id).orElseThrow(()-> new ResourceNotFoundException("Resource Not Found!"));
        repository.deleteById(product.getProductId());

    }

}
