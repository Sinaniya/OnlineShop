package com.example.demo.mappings;


import com.example.demo.model.Product;
import com.example.demo.model.resource.ProductDto;
import org.mapstruct.*;

import java.util.List;

@Mapper
public interface ProductMapper {

    @Mappings(value = {
            @Mapping(source = "id",target = "id"),
            @Mapping(target = "orderIds", expression = "java(product.getOrders().stream().map(order -> order.getId()).collect(java.util.stream.Collectors.toList()))"),
            @Mapping(target = "basketIds", expression = "java(product.getBaskets().stream().map(basket -> basket.getId()).collect(java.util.stream.Collectors.toList()))")
    })
    ProductDto toProductDto(Product product);

    @InheritConfiguration
    List<ProductDto> toProductDto(List<Product> product);

    @InheritInverseConfiguration
    Product toProduct(ProductDto productDto);

    @InheritInverseConfiguration
    List<Product> toProduct(List<ProductDto> productDtoList);
}
