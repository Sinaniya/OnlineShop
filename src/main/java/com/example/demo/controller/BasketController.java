package com.example.demo.controller;

import com.example.demo.model.resource.UserDto;
import com.example.demo.services.BasketService;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.mappings.BasketMapper;
import com.example.demo.model.Basket;
import com.example.demo.model.resource.BasketDto;
import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/basket")
public class BasketController {

    BasketService service;
    BasketMapper mapper = Mappers.getMapper(BasketMapper.class);

    @PostMapping
    public ResponseEntity create(@RequestBody BasketDto basketDto) {
        service.save(mapper.toBasket(basketDto));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


    @CrossOrigin(origins = "http://localhost:3001")
    @GetMapping("baskets")
    public ResponseEntity<List<BasketDto>> baskets() {
        List<Basket> baskets = service.findAll();
        return ResponseEntity.ok().body(mapper.toBasketsDto(baskets));

    }


@GetMapping("baskets/{id}")
    public ResponseEntity<BasketDto> getBasket (@PathVariable("id") long id){

        Basket basket = service.findAll().stream().filter(b -> b.getId()==id).findFirst().orElseThrow(() -> new ResourceNotFoundException("Not found"));
        return ResponseEntity.ok().body(mapper.toBasketDto(basket));

    }


    @CrossOrigin(origins = "http://localhost:3003")
    @DeleteMapping("baskets/{id}")
    public ResponseEntity deleteasket(@PathVariable ("id") long id){

        service.deleteById(id);
        return ResponseEntity.ok().build();

    }

}
