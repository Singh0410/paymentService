package com.example.payamentservice.PaymantGateway;

import com.razorpay.RazorpayClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;
@Service
public class PaymentGatewayFactory {

    private final RazorPayPaymentGateway razorPayPaymentGateway;

    @Autowired
    public PaymentGatewayFactory(RazorPayPaymentGateway razorPayPaymentGateway) {
        this.razorPayPaymentGateway = razorPayPaymentGateway;
    }

    public PaymentGatewayInterface getBestPaymentgateway() {
        return razorPayPaymentGateway;
    }
}

