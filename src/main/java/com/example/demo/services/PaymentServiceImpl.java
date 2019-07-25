
package com.example.demo.services;

import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.repository.PaymentRepository;
import com.example.demo.model.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class PaymentServiceImpl implements PaymentService{

    @Autowired private PaymentRepository repository;

    @Override
    public List<Payment> findAll() {return repository.findAll();}

    @Transactional
    @Override
    public void save(Payment payment) {
        repository.save(payment);

    }

    @Transactional
    @Override
    public void delete (Payment payment){repository.deleteById(payment.getPaymentId());}

    @Transactional
    @Override
    public void deleteById(Long id){
        Payment payment = repository.findByPaymentId(id).orElseThrow(()-> new ResourceNotFoundException("Resource Not Found!"));
        repository.deleteById(payment.getPaymentId());

    }

}


