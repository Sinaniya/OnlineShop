package com.example.demo.mappings;

import com.example.demo.model.Payment;
import com.example.demo.model.resource.PaymentDto;
import org.mapstruct.*;

import java.util.List;

@Mapper
public interface PaymentMapper {

    @Mappings(value = {
            @Mapping(source = "paymentId", target = "id"),
            @Mapping(source = "order.id", target = "orderId")
    })
    PaymentDto toPaymentDto(Payment payment);

    @InheritConfiguration
    List<PaymentDto> toPaymentsDto(List<Payment> payments);

    @InheritInverseConfiguration
    Payment toPayment(PaymentDto paymentDto);

    @InheritInverseConfiguration
    List<Payment> toPayments(List<PaymentDto> paymentDtoList);

}
