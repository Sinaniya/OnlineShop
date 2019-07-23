

 package com.example.demo.Controller;

import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.Services.OrderService;
import com.example.demo.mappings.OrderMapper;
import com.example.demo.model.Order;
import com.example.demo.model.resource.OrderDto;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class OrderController {

    @Autowired
    OrderService service;
    OrderMapper mapper = Mappers.getMapper(OrderMapper.class);

    @CrossOrigin(origins="http://localhost:3000")
    @GetMapping("orders")
    public ResponseEntity<List<OrderDto>> orders(){
        List<Order>orders=service.findAll();
        return ResponseEntity.ok().body(mapper.toOrdersDto(orders));
    }

    @GetMapping("orders/{id}")
    public ResponseEntity<OrderDto> getOrder(@PathVariable("id") long id){

        Order order = service.findAll().stream().filter(u -> u.getId() == id).findFirst().orElseThrow(()-> new ResourceNotFoundException("Not found"));
         return ResponseEntity.ok().body(mapper.toOrdersDto(order));
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("orders/{id}")
    public ResponseEntity deleteOrder(@PathVariable("id") long id){

        service.deleteById(id);
        return ResponseEntity.ok().build();

    }

}

