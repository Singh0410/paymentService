package com.example.payamentservice.Models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Payment extends BaseModel {

    private Long amount;
    private PaymentStatus paymentStatus;
    private Long UserId;
    private Long OrderId;
    private String PaymentLink;
    private String PaymentGatewayReferenceID;
    private PaymentGateway paymentGateway;

}
