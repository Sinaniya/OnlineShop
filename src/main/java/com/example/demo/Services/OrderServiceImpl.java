package com.example.demo.Services;

import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.Repository.OrderRepository;
import com.example.demo.model.Order;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)

public class OrderServiceImpl implements OrderService{

    @Override
  private OrderRepository repository;

    @Override
    public List<Order> findAll() {return repository.findAll();}

    @Transactional
    @Override
    public void delete (Order order){repository.deleteById(order.getId());}

    @Transactional
    @Override
    public void deleteById(Long id){
        Order order = repository.findOrderById(id).orElseThrow(()-> new ResourceNotFoundException("Resource Not Found!"));
        repository.deleteById(order.getId());

    }

}




