package com.example.demo.controller;

import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.mappings.BasketMapper;
import com.example.demo.mappings.OrderMapper;
import com.example.demo.mappings.UserMapper;
import com.example.demo.model.User;
import com.example.demo.model.requests.product.AddProductToBasketRequestDto;
import com.example.demo.model.resource.BasketDto;
import com.example.demo.model.resource.OrderDto;
import com.example.demo.model.resource.ProductDto;
import com.example.demo.model.resource.UserDto;
import com.example.demo.services.BasketService;
import com.example.demo.services.OrderService;
import com.example.demo.services.UserService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    UserService service;

    @Autowired
    OrderService orderService;
    BasketService basketService;
    UserMapper mapper = Mappers.getMapper(UserMapper.class);
    OrderMapper orderMapper = Mappers.getMapper(OrderMapper.class);
    BasketMapper basketMapper = Mappers.getMapper(BasketMapper.class);


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


    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("users/{id}")
    public ResponseEntity deleteUser(@PathVariable("id") long id) {

        service.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("users/{id}/orders/{orderId}")
    public ResponseEntity deleteOrder(@PathVariable long id, @PathVariable long orderId) {
        service.removeOrder(id, orderService.findById(orderId).orElseThrow(() -> {
            return new RuntimeException("Order not found!");
        }));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/{id}/baskets")
    public ResponseEntity createBasket(@PathVariable long id, @RequestBody BasketDto dto) {
        service.addBasket(id, basketMapper.toBasket(dto));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("users/{id}/baskets/{basketId}")
    public ResponseEntity deleteBasket(@PathVariable long id, @PathVariable long basketId) {

        service.removeBasket(id, basketService.findById(basketId).orElseThrow(() -> {
            return new RuntimeException("Basket not found!");
        }));
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }


    @PostMapping("/{id}/baskets/{basketId}/products/")
    public ResponseEntity createProduct(@PathVariable("id") long id, @PathVariable long basketId, @RequestBody AddProductToBasketRequestDto dto) {

        service.addProductToBasket(id, basketId, dto.getProductId());
//        service.addProduct(id,basketService.findById(basketId).orElseThrow(() -> {
//            return new RuntimeException("Basket not found!");
//        }));
//        service.addProduct(id, basketId, productMapper.topProduct(dto));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}




