package com.example.demo.services;

import com.example.demo.repository.OrderRepository;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)

public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository repository;

    @Override
    public List<Order> findAll() {
        return repository.findAll();
    }

    @Transactional
    @Override
    public void save(Order order) {
        repository.save(order);
    }

    @Transactional
    @Override
    public void delete(Order order) {
        repository.deleteById(order.getId());
    }

    @Transactional
    @Override
    public void deleteById(long id) {
        Order order = repository.findOrderById(id).orElseThrow(() -> new ResourceNotFoundException("Resource Not Found!"));
        repository.deleteById(order.getId());

    }

    @Override
    public Optional<Order> findById(long orderId) {
        return repository.findById(orderId);
    }

}




