package ecommerce.sales.reservation;

import ecommerce.payu.OrderCreateRequest;
import ecommerce.sales.payment.PaymentDetails;
import ecommerce.sales.payment.PaymentGateway;
import ecommerce.sales.payment.RegisterPaymentRequest;

import java.util.UUID;

public class SpyPaymentGateway implements PaymentGateway {
    Integer requestCount = 0;
    public RegisterPaymentRequest lastRequest;

    public Integer getRequestsCount() {
        return requestCount;
    }

    @Override
    public PaymentDetails registerPayment(RegisterPaymentRequest registerPaymentRequest) {
        this.requestCount++;
        lastRequest = registerPaymentRequest;
        return new PaymentDetails(
                "http://spy-gateway",
                UUID.randomUUID().toString(),
                UUID.randomUUID().toString());
    }

    @Override
    public PaymentDetails registerPayment(OrderCreateRequest registerPaymentRequest) {
        return null;
    }
}
