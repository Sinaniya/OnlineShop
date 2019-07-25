package com.example.demo.mappings;

import com.example.demo.model.Order;
import com.example.demo.model.resource.OrderDto;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(uses = {PaymentMapper.class, ProductMapper.class})
public interface OrderMapper {
    @Mapping(source = "user.id", target = " userId")
    OrderDto toOrderDto(Order order);

    @InheritConfiguration
    List<OrderDto> toOrdersDto(List<Order> orders);

    @InheritInverseConfiguration
    Order toOrder(OrderDto orderDto);

    @InheritInverseConfiguration
    List<Order> toOrders(List<OrderDto> orderDtoList);
}
