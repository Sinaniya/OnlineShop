package com.example.demo.Controller;

import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.Services.UserService;
import com.example.demo.mappings.UserMapper;
import com.example.demo.model.User;
import com.example.demo.model.resource.UserDto;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class UserController {

    @Autowired
    UserService service;
    UserMapper mapper = Mappers.getMapper(UserMapper.class);

    @CrossOrigin(origins="http://localhost:3000")
    @GetMapping("users")
    public ResponseEntity<List<UserDto>> users(){
        List<User>users=service.findAll();
        return ResponseEntity.ok().body(mapper.toUsersDto(users));
    }

    @GetMapping("users/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable("id") long id){

        User user = service.findAll().stream().filter(u -> u.getId() == id).findFirst().orElseThrow(()-> new ResourceNotFoundException("Not found"));
         return ResponseEntity.ok().body(mapper.toUsersDto(user));
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("users/{id}")
    public ResponseEntity deleteUser(@PathVariable("id") long id){

        service.deleteById(id);
        return ResponseEntity.ok().build();

    }

}
