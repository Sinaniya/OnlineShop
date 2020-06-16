package com.example.demo.controller;

import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.mappings.OrderMapper;
import com.example.demo.mappings.UserMapper;
import com.example.demo.model.User;
import com.example.demo.model.resource.OrderDto;
import com.example.demo.model.resource.UserDto;
import com.example.demo.services.OrderService;
import com.example.demo.services.UserService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    UserService service;

    @Autowired
    OrderService orderService;
    UserMapper  mapper      = Mappers.getMapper(UserMapper.class);
    OrderMapper orderMapper = Mappers.getMapper(OrderMapper.class);


    @PostMapping
    public ResponseEntity create(@RequestBody UserDto userDto) {
        service.save(mapper.toUser(userDto));
        //service.addOrder(userDto.getId());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("users")
    public ResponseEntity<List<UserDto>> users() {
        List<User> users = service.findAll();
        return ResponseEntity.ok().body(mapper.toUsersDto(users));
    }

    @GetMapping("users/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable("id") long id) {

        User user = service.findAll().stream().filter(u -> u.getId() == id).findFirst().orElseThrow(() -> new ResourceNotFoundException("Not found"));
        return ResponseEntity.ok().body(mapper.toUserDto(user));
    }

    @PostMapping("users/{id}/orders")
    public ResponseEntity createOrder(@PathVariable long id, @RequestBody OrderDto dto) {
        service.addOrder(id, orderMapper.toOrder(dto));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("users/{id}/orders/{orderId}")
    public ResponseEntity deleteOrder(@PathVariable long id, @PathVariable long orderId) {
        service.removeOrder(id, orderService.findById(orderId).orElseThrow(() -> {
            return new RuntimeException("Order not found!");
        }));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("users/{id}")
    public ResponseEntity deleteUser(@PathVariable("id") long id) {

        service.deleteById(id);
        return ResponseEntity.ok().build();

    }

}
