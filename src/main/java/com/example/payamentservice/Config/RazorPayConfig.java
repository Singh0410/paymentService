package com.example.payamentservice.Config;

import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RazorPayConfig {

    @Value("${razorpay.key_id}")
    private String razorpayKeyId;

    @Value("${razorpay.key_Secret}")
    private String razorpayKeySecret;

        @Bean
        public RazorpayClient createRazorpayClient() throws RazorpayException
        {
            return new RazorpayClient(razorpayKeyId,razorpayKeySecret);
        }
}
