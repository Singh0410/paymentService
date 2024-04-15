package com.example.payamentservice.Service;

import com.example.payamentservice.Models.Payment;
import com.example.payamentservice.Models.PaymentGateway;
import com.example.payamentservice.Models.PaymentStatus;
import com.example.payamentservice.PaymantGateway.PaymentGatewayFactory;
import com.example.payamentservice.PaymantGateway.PaymentGatewayInterface;
import com.example.payamentservice.PaymantGateway.RazorPayPaymentGateway;
import com.example.payamentservice.Repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService
{

        private final PaymentGatewayFactory paymentGatewayFactory;
        private  PaymentRepository paymentRepository;

        @Autowired
        public PaymentService(PaymentGatewayFactory paymentGatewayFactory,PaymentRepository paymentRepository) {
            this.paymentGatewayFactory = paymentGatewayFactory;
            this.paymentRepository=paymentRepository;
        }

        public String createPaymentLink(Long orderId) {
            // Assuming you have a way to retrieve the order details
            Long amount = 1000L;
            String userName = "singh04";
            String userMobile = "9668376045";
            String userEmail = "ameetsingh79@gmail.com";

            PaymentGatewayInterface paymentGateway = paymentGatewayFactory.getBestPaymentgateway();

            String PayemntLink= paymentGateway.createPaymentLink(amount, userName, userMobile, userEmail, orderId);

            Payment payment = new Payment();
            payment.setPaymentLink(PayemntLink);
            payment.setOrderId(orderId);
            payment.setPaymentGateway(PaymentGateway.RAZORPAY);
            payment.setPaymentStatus(PaymentStatus.PENDING);
            payment.setAmount(amount);

            paymentRepository.save(payment);
            return PayemntLink;
        }

    public PaymentStatus getPaymentStatus(Long PaymentId)
    {
        return null;
    }
}