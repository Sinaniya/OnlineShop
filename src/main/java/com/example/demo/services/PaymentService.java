package com.example.demo.services;

import com.example.demo.model.Payment;

import java.util.List;

public interface PaymentService {

    List<Payment> findAll();

    void save(Payment payment);

    void delete(Payment payment);

    void deleteById(Long id);
}
