
package com.example.demo.Services;

import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.Repository.PaymentRepository;
import com.example.demo.model.Payment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)

public class PaymentServiceImpl implements PaymentService{

    @Override
  private PaymentRepository repository;

    @Override
    public List<Payment> findAll() {return repository.findAll();}

    @Transactional
    @Override
    public void delete (Payment payment){repository.deleteById(payment.getPaymentId());}

    @Transactional
    @Override
    public void deleteById(Long id){
        Payment payment = repository.findPaymentById(id).orElseThrow(()-> new ResourceNotFoundException("Resource Not Found!"));
        repository.deleteById(payment.getPaymentId());

    }

}


