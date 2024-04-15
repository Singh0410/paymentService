package com.example.payamentservice.PaymantGateway;

import com.example.payamentservice.Models.PaymentStatus;
import com.razorpay.PaymentLink;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RazorPayPaymentGateway implements PaymentGatewayInterface{
   private RazorpayClient razorpayClient;

   public RazorPayPaymentGateway(RazorpayClient razorpayClient)
   {
       this.razorpayClient=razorpayClient;
   }


    @Override
    public String createPaymentLink(Long amount, String UserName, String UserPhone,String UserEmail,Long orderId) {

        JSONObject paymentLinkRequest = new JSONObject();
        paymentLinkRequest.put("amount",amount);
        paymentLinkRequest.put("currency","INR");
        paymentLinkRequest.put("accept_partial",true);
        //paymentLinkRequest.put("first_min_partial_amount",100);
        paymentLinkRequest.put("expire_by",System.currentTimeMillis()/1000+30*60); //epoctimestamp
        paymentLinkRequest.put("reference_id",orderId.toString());
        //paymentLinkRequest.put("description","Payment for policy no #23456");
        JSONObject customer = new JSONObject();
        customer.put("name",UserName);
        customer.put("contact",UserPhone);
        customer.put("email",UserEmail);

        paymentLinkRequest.put("customer",customer);
        JSONObject notify = new JSONObject();
        notify.put("sms",true);
        notify.put("email",true);
        paymentLinkRequest.put("reminder_enable",true);
        //JSONObject notes = new JSONObject();
       // notes.put("policy_name","Jeevan Bima");
       // paymentLinkRequest.put("notes",notes);
        paymentLinkRequest.put("callback_url","http://127.0.0.1:5500/Ameet/index.html");
        paymentLinkRequest.put("callback_method","get");

        PaymentLink payment=null;
        try
        {
            payment=razorpayClient.paymentLink.create(paymentLinkRequest);
        }
        catch (RazorpayException razorpayException)
        {
            System.out.println(razorpayException);
            System.out.println("Something went wrong");
        }
        return payment.get("short_url");
    }


    @Override
    public PaymentStatus getPaymentStatus(Long paymentId) {
        return null;
    }
}
