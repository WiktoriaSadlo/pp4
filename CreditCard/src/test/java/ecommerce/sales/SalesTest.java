package ecommerce.sales;

import ecommerce.sales.cart.CartStorage;
import ecommerce.sales.offering.Offer;
import ecommerce.sales.offering.OfferCalculator;
import ecommerce.sales.reservation.ReservationRepository;
import ecommerce.sales.reservation.SpyPaymentGateway;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SalesTest {
    @Test
    void itAddProductToCart() {
        String customerId = thereIsCustomer("Wiktoria");
        String productId = thereIsProduct("product a",BigDecimal.valueOf(10));
        SalesFacade sales=thereIsSales();

        sales.addToCart(customerId, productId);

        Offer currentOffer=sales.getCurrentOffer(customerId);
        assertThat(currentOffer.getTotal()).isEqualTo(BigDecimal.valueOf(10));
        assertThat(currentOffer.getItemsCount()).isEqualTo(1);


    }

    private String thereIsProduct(String productId, BigDecimal productPrice) {
        return productId;
    }

    private SalesFacade thereIsSales() {
        return new SalesFacade(
                new CartStorage(),
                new OfferCalculator(),
                new SpyPaymentGateway(),
                new ReservationRepository()
        );
    }

    @Test
    void itShowsCurrentOffer() {
        String customerId = thereIsCustomer("Wiktoria");
        SalesFacade sales = thereIsSales();

        Offer offer = sales.getCurrentOffer(customerId);

        assertThat(offer.getTotal()).isEqualTo(BigDecimal.ZERO);
        assertThat(offer.getItemsCount()).isEqualTo(0);
    }

    private String thereIsCustomer(String name) {
        return name;
    }

    @Test
    void itRemoveProductFromCart() {

    }

    @Test
    void itAllowToAcceptOffer() {

    }

    @Test
    void itAllowToPayForReservation(){

    }


}