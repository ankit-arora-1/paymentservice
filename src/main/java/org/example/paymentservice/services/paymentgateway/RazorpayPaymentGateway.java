package org.example.paymentservice.services.paymentgateway;

import com.razorpay.PaymentLink;
import org.json.JSONObject;
import com.razorpay.Payment;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.springframework.stereotype.Service;

@Service
public class RazorpayPaymentGateway implements PaymentGateway {
    @Override
    public String generateLink() {

        try {
            RazorpayClient razorpay =
                    new RazorpayClient("rzp_test_RMfSs9QFi0TYqh",
                            "HZHFS8HCjE8qpC1deUXa1Zav");
            JSONObject paymentLinkRequest = new JSONObject();
            paymentLinkRequest.put("amount",1000);
            paymentLinkRequest.put("currency","INR");
            paymentLinkRequest.put("accept_partial",false);
            paymentLinkRequest.put("expire_by",1709345863);
            paymentLinkRequest.put("reference_id","TS1989");
            paymentLinkRequest.put("description","Payment for policy no #23456");

            JSONObject customer = new JSONObject();
            customer.put("contact","+917337057594");
            customer.put("name","Ankit Arora");
            customer.put("email","arora.ankit7@gmail.com");
            paymentLinkRequest.put("customer",customer);

            JSONObject notify = new JSONObject();
            notify.put("sms",true);
            notify.put("email",true);
            paymentLinkRequest.put("notify",notify);

            paymentLinkRequest.put("callback_url","https://google.com/");
            paymentLinkRequest.put("callback_method","get");

            PaymentLink payment = razorpay.paymentLink.create(paymentLinkRequest);

            return payment.toString();
        } catch(Exception e) {
            System.out.println(e);
        }

        return null;
    }
}
