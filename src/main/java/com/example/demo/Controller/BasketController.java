package com.example.demo.Controller;

import com.example.demo.Services.BasketService;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.mappings.BasketMapper;
import com.example.demo.model.Basket;
import com.example.demo.model.resource.BasketDto;
import org.mapstruct.factory.Mappers;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class BasketController {

    BasketService service;
    BasketMapper mapper = Mappers.getMapper(BasketMapper.class);

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
