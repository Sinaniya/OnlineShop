package com.example.demo.controller;

import com.example.demo.services.ProductService;
import com.example.demo.mappings.ProductMapper;
import com.example.demo.model.Product;
import com.example.demo.model.resource.ProductDto;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class ProductController {


    @Autowired
    ProductService service;

    ProductMapper mapper = Mappers.getMapper(ProductMapper.class);

    @PostMapping("products")
    public ResponseEntity create(@RequestBody ProductDto productDto){

        service.save(mapper.toProduct(productDto));

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @CrossOrigin(origins="http://localhost:3004")
    @GetMapping("products")
    public ResponseEntity<List<ProductDto>> products(){
       List<Product> products = service.findAll();
        return ResponseEntity.ok().body(mapper.toProductDto(products));

    }


    @PutMapping("products")
    public ResponseEntity update(@RequestBody ProductDto productDto){
        service.

    }



}


