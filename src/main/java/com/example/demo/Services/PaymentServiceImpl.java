package com.example.demo.Services;

import com.example.demo.Repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class PaymentServiceImpl implements PaymentService {

    @Autowired
   private PaymentRepository repository;


}

/*
*
* @Transactional
    @Override
    public void delete (Order order){repository.deleteById(order.getId());}

    @Transactional
    @Override
    public void deleteById(Long id){
        Order order = repository.findOrderById(id).orElseThrow(()-> new ResourceNotFoundException("Resource Not Found!"));
        repository.deleteById(order.getId());

    }

* */