package com.example.demo.Controller;

import com.example.demo.Services.ProductService;
import com.example.demo.mappings.ProductMapper;
import com.example.demo.model.Product;
import com.example.demo.model.resource.ProductDto;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class ProductController {


    @Autowired
    ProductService service;

    ProductMapper mapper = Mappers.getMapper(ProductMapper.class);

    @CrossOrigin(origins="http://localhost:3004")
    @GetMapping("products")
    public ResponseEntity<List<ProductDto>> products(){
       List<Product> products = service.findAll();
        return ResponseEntity.ok().body(mapper.toProductDto(products));

    }


}


