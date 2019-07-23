package com.example.demo.mappings;

import com.example.demo.model.Order;
import com.example.demo.model.resource.OrderDto;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface OrderMapper {
@Mapping(source="user.id", target = " userId")
OrderDto toOrdersDto(List<Order> orders);

@InheritConfiguration
    List<OrderDto> toTaskDto(List<Order> orders);

@InheritInverseConfiguration
    Order toOrder (OrderDto orderDto);

@InheritInverseConfiguration
    List<Order> toOrders (List<OrderDto> orderDtoList);
}
