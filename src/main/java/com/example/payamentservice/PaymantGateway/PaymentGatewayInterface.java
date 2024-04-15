package com.example.payamentservice.PaymantGateway;

import com.example.payamentservice.Models.PaymentStatus;

public interface PaymentGatewayInterface {

    String createPaymentLink(Long amount,String userName,String userEmail,String userPhone,Long orderId);

    PaymentStatus getPaymentStatus(Long paymentId);
}
