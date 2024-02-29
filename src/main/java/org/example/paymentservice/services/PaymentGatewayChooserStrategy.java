package org.example.paymentservice.services;

import org.example.paymentservice.services.paymentgateway.PaymentGateway;
import org.example.paymentservice.services.paymentgateway.RazorpayPaymentGateway;
import org.example.paymentservice.services.paymentgateway.StripePaymentGateway;
import org.springframework.stereotype.Service;

@Service
public class PaymentGatewayChooserStrategy {
    private RazorpayPaymentGateway razorpayPaymentGateway;
    private StripePaymentGateway stripePaymentGateway;

    public PaymentGatewayChooserStrategy(RazorpayPaymentGateway razorpayPaymentGateway,
                                         StripePaymentGateway stripePaymentGateway) {
        this.razorpayPaymentGateway = razorpayPaymentGateway;
        this.stripePaymentGateway = stripePaymentGateway;
    }

    public PaymentGateway getBestPaymentGateway() {
        // Some logic to chooese the best payment gateway
        return stripePaymentGateway;
    }
}
