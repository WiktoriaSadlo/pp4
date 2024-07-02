package ecommerce.sales.payment;

import ecommerce.payu.OrderCreateRequest;

public  interface PaymentGateway {

    PaymentDetails registerPayment(RegisterPaymentRequest registerPaymentRequest);

    PaymentDetails registerPayment(OrderCreateRequest registerPaymentRequest);
}
