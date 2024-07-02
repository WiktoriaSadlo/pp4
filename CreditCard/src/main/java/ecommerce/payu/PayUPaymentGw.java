package ecommerce.payu;

import ecommerce.sales.payment.PaymentDetails;
import ecommerce.sales.payment.PaymentGateway;
import ecommerce.sales.payment.RegisterPaymentRequest;
import ecommerce.payu.PayU;


import java.util.Arrays;
import java.util.UUID;

public class PayUPaymentGw implements PaymentGateway {
    private PayU payU;

    public PayUPaymentGw(PayU payU) {
        this.payU = payU;
    }

    public PayUPaymentGw() {

    }

    @Override
    public PaymentDetails registerPayment(RegisterPaymentRequest registerPaymentRequest) {
        return null;
    }

    @Override
    public PaymentDetails registerPayment(OrderCreateRequest request) {
        OrderCreateResponse response = payU.handle(request);
        return new PaymentDetails(
                response.getRedirectUri(),
                request.getExtOrderId(),
                UUID.randomUUID().toString()
        );
    }
}
