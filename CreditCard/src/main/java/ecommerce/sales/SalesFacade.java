package ecommerce.sales;


import ecommerce.sales.cart.Cart;
import ecommerce.sales.cart.CartStorage;
import ecommerce.sales.offering.Offer;
import ecommerce.sales.offering.OfferCalculator;
import ecommerce.sales.payment.PaymentDetails;
import ecommerce.sales.payment.PaymentGateway;
import ecommerce.sales.payment.RegisterPaymentRequest;
import ecommerce.sales.reservation.AcceptOfferRequest;
import ecommerce.sales.reservation.Reservation;
import ecommerce.sales.reservation.ReservationDetail;
import ecommerce.sales.reservation.ReservationRepository;

import java.util.UUID;

public class SalesFacade {
    private OfferCalculator offerCalculator;
    private CartStorage cartStorage;
    private PaymentGateway paymentGateway;
    private ReservationRepository reservationRepository;

    public SalesFacade(CartStorage cartStorage, OfferCalculator offerCalculator, PaymentGateway paymentGateway, ReservationRepository reservationRepository){
        this.cartStorage = cartStorage;
        this.offerCalculator = offerCalculator;
        this.paymentGateway = paymentGateway;
        this.reservationRepository = reservationRepository;
    }
    public void addToCart(String customerId, String productId) {
        Cart cart = loadCartForCustomer(customerId);

        cart.addProduct(productId);

        cartStorage.save(customerId, cart);
    }

    private Cart loadCartForCustomer(String customerId) {
        return cartStorage.getForCustomer(customerId)
                .orElse(Cart.empty());
    }

    public Offer getCurrentOffer(String customerId) {
        Cart cart = loadCartForCustomer(customerId);
        Offer offer = offerCalculator.calculate(cart.getCartItems());

        return offer;
    }

    public ReservationDetail acceptOffer(String customerId, AcceptOfferRequest acceptOfferRequest) {
        String reservationId = UUID.randomUUID().toString();
        Offer offer = this.getCurrentOffer(customerId);

        PaymentDetails paymentDetails = paymentGateway.registerPayment(
                RegisterPaymentRequest.of(reservationId, acceptOfferRequest, offer.getTotal())
        );

        Reservation reservation = Reservation.of(
                reservationId,
                customerId,
                acceptOfferRequest,
                offer,
                paymentDetails);

        reservationRepository.add(reservation);

        return new ReservationDetail(reservationId, paymentDetails.getPaymentUrl());
    }

}