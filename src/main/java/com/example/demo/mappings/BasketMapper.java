package com.example.demo.mappings;

import com.example.demo.model.Basket;
import com.example.demo.model.resource.BasketDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(uses = ProductMapper.class)
public interface BasketMapper {

    @Mapping(source = "user.id", target = "userId")
    BasketDto toBasketDto(Basket basket);

    List<BasketDto> toBasketsDto(List<Basket> baskets);

    Basket toBasket(BasketDto basketDto);

    List<Basket> toBaskets(List<BasketDto> basketDtoList);


}
