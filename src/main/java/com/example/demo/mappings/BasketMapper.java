package com.example.demo.mappings;
import com.example.demo.model.Basket;
import com.example.demo.model.resource.BasketDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(uses= ProductMapper.class)
public interface BasketMapper {

        BasketDto toBasketDto(Basket basket);
        List<BasketDto> toBasketsDto(List<Basket> baskets);
        Basket toBasket(BasketDto basketDto);
        List<Basket> toBaskets(List<BasketDto> basketDtoList);


}
