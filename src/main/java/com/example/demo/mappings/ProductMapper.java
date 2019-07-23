package com.example.demo.mappings;


import com.example.demo.model.Product;
import com.example.demo.model.resource.ProductDto;
import org.h2.util.Task;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface ProductMapper {

@Mapping(source = "order.id", target="orderId")
ProductDto toProductDto(Task task);

@InheritConfiguration
    List<ProductDto> toProductDto(List<Product> product);

@InheritInverseConfiguration
    Product toProduct (ProductDto productDto);

@InheritInverseConfiguration
List<Product> toProduct(List<ProductDto> productDtoList);
}
