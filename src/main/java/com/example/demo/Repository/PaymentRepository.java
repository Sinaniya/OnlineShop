package com.example.demo.Repository;


import com.example.demo.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {

 Optional<Payment> findPaymentById(long id);
}