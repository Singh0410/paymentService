package com.example.payamentservice.PaymantGateway;

import com.example.payamentservice.Models.PaymentStatus;

public class StripePaymentGateway implements PaymentGatewayInterface{
    @Override
    public String createPaymentLink(Long amount, String UserName, String UserEmail, String UserPhone,Long orderId) {
        return null;
    }

    @Override
    public PaymentStatus getPaymentStatus(Long paymentId) {
        return null;
    }
}
