package org.example.paymentservice.services;

import org.example.paymentservice.services.paymentgateway.PaymentGateway;
import org.example.paymentservice.services.paymentgateway.RazorpayPaymentGateway;
import org.springframework.stereotype.Service;

@Service
public class PaymentGatewayChooserStrategy {
    private RazorpayPaymentGateway razorpayPaymentGateway;

    public PaymentGatewayChooserStrategy(RazorpayPaymentGateway razorpayPaymentGateway) {
        this.razorpayPaymentGateway = razorpayPaymentGateway;
    }

    public PaymentGateway getBestPaymentGateway() {
        // Some logic to chooese the best payment gateway
        return razorpayPaymentGateway;
    }
}
