 package com.example.demo.controller;

import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.model.resource.UserDto;
import com.example.demo.services.PaymentService;
import com.example.demo.mappings.PaymentMapper;
import com.example.demo.model.Payment;
import com.example.demo.model.resource.PaymentDto;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class PaymentController {

    @Autowired
    PaymentService service;
    PaymentMapper mapper = Mappers.getMapper(PaymentMapper.class);

    @CrossOrigin(origins="http://localhost:3000")
    @GetMapping("payments")
    public ResponseEntity<List<PaymentDto>> payments(){
        List<Payment>payments=service.findAll();
        return ResponseEntity.ok().body(mapper.toPaymentsDto(payments));
    }

    @GetMapping("payments/{id}")
    public ResponseEntity<PaymentDto> getPayment(@PathVariable("id") long id){

        Payment payment = service.findAll().stream().filter(u -> u.getPaymentId() == id).findFirst().orElseThrow(()-> new ResourceNotFoundException("Not found"));
         return ResponseEntity.ok().body(mapper.toPaymentDto(payment));
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("payments/{id}")
    public ResponseEntity deletePayment(@PathVariable("id") long id){

        service.deleteById(id);
        return ResponseEntity.ok().build();

    }


    @PostMapping
    public ResponseEntity create(@RequestBody PaymentDto paymentDto) {
        service.save(mapper.toPayment(paymentDto));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}

