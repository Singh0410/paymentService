package com.example.payamentservice.Controller;


import com.example.payamentservice.Models.PaymentGateway;
import com.example.payamentservice.Models.PaymentStatus;
import com.example.payamentservice.Service.PaymentService;
import com.example.payamentservice.dtos.CreatePaymentLinkRequestDTO;
import com.example.payamentservice.dtos.CreatePaymentLinkResponseDTo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Payments/")
public class PaymentController {

    private PaymentService paymentService;
    public PaymentController(PaymentService paymentService)
    {
        this.paymentService=paymentService;
    }

    @PostMapping()
   public CreatePaymentLinkResponseDTo CreatePaymentLink(@RequestBody CreatePaymentLinkRequestDTO createPaymentLinkRequestDTO)
    {
        String redirectUrl= this.paymentService.createPaymentLink(createPaymentLinkRequestDTO.getOrderId());
        CreatePaymentLinkResponseDTo responseDTo= new CreatePaymentLinkResponseDTo();
        responseDTo.setUrl(redirectUrl);
        return responseDTo;
    }
    @GetMapping("/{id}")
    public PaymentStatus CheckPaymentStatus(@PathVariable("id") Long PaymentGatewayPaymentId){
        return paymentService.getPaymentStatus(PaymentGatewayPaymentId);
    }

}

//user---->createOrder()-->orderservice
//user----->createpaymentLink()----->paymentservice
