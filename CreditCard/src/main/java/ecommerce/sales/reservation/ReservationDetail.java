package ecommerce.sales.reservation;

import java.math.BigDecimal;
public class ReservationDetail {
    private String reservationId;
    private String paymentUrl;

    public ReservationDetail(String reservationId, String paymentUrl) {
        this.reservationId = reservationId;
        this.paymentUrl = paymentUrl;
    }

    ReservationDetail() {

    }

    public String getReservationId(){
        return reservationId;
    }

    public String getPaymentUrl(){
        return paymentUrl;
    }
}
