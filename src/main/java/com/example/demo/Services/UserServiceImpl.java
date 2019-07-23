package com.example.demo.Services;

import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.Repository.UserRpository;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly=true)
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRpository repository;

    @Override
    public List<User> findAll() {return repository.findAll();}

    @Override
    public List<User> filterByName (String name){

        List<User> users = findAll();
        List<User> result=users.stream().filter(user -> user.getUserName().startsWith(name)).collect(Collectors.toList());
    return result;
    }

    @Transactional
    @Override
    public void save (User user){
        Optional<User> u = repository.findUserByUserName(user.getUserName());
        if(!u.isPresent()){
            repository.save(user);
        }
    }

    @Transactional
    @Override
    public void delete(User user){repository.deleteById(user.getId());}

    @Override
    public void deleteByName (String name){
        repository.findUserByUserName(name).ifPresent(user -> {
            repository.delete(user);
        });
     }

     @Transactional
    @Override
    public void deleteById(long id){
        User user= repository.findUserById(id).orElseThrow(()->new ResourceNotFoundException("Resource not found!"));
        repository.deleteById(user.getId());
     }



}
