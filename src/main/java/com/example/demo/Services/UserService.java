package com.example.demo.Services;

import com.example.demo.model.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    List<User> filterbyName (String name);

    void save (User user);

    void delete (User user);

    void deleteByName(String name);

    void deleteById(long id);

}
