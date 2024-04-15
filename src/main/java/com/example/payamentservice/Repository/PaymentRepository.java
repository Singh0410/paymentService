package com.example.payamentservice.Repository;

import com.example.payamentservice.Models.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment,Long> {
    Payment save(Payment payment);
}
