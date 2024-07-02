package ecommerce.sales.payment;

public class PaymentDetails {
    private final String url;
    private final String reservationId;
    private  final String paymentId;

    public PaymentDetails(String url, String reservationId, String paymentId) {
        this.url = url;
        this.reservationId = reservationId;
        this.paymentId = paymentId;
    }

    public String getPaymentUrl() {
        return url;
    }

    public String getReservationId() {
        return reservationId;
    }

    public String getPaymentId() {
        return paymentId;
    }


}
