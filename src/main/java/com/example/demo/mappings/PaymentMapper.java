 package com.example.demo.mappings;

import com.example.demo.model.Payment;
import com.example.demo.model.resource.PaymentDto;
import org.mapstruct.Mapper;

import java.util.List;
//what about the Basket?
@Mapper(uses=OrderMapper.class)
public interface PaymentMapper {
    PaymentDto toPaymentDto(Payment payment);
    List<PaymentDto> toPaymentsDto(List<Payment> payments);
    Payment toPayment(PaymentDto paymentDto);
    List<Payment> toPayments(List<PaymentDto> paymentDtoList);

}
