package ecommerce.sales;

import ecommerce.sales.offering.Offer;
import ecommerce.sales.reservation.AcceptOfferRequest;
import ecommerce.sales.reservation.ReservationDetail;
import ecommerce.catalog.ProductCatalog;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SalesHTTPTest {
    @LocalServerPort
    int port;

    @Autowired
    TestRestTemplate http;

    @Autowired
    ProductCatalog catalog;

    @Test
    void itAllowsToAcceptOfferHappyPath() {
        String productId = thereIsProduct("product-x", BigDecimal.valueOf(10.10));
        var addProductToCartUrl = asBaseURL(String.format("api/add-product/%s", productId));

        ResponseEntity<Object> addProductResponse = http.postForEntity(addProductToCartUrl, null, null);

        var getCurrentOfferUrl = asBaseURL("api/current-offer");
        ResponseEntity<Offer> offerResponse = http.getForEntity(getCurrentOfferUrl, Offer.class);

        var acceptOfferUrl = asBaseURL("api/accept-offer");
        var acceptOfferRequest = new AcceptOfferRequest();
        acceptOfferRequest
                .setFirstname("john")
                .setLastname("doe")
                .setEmail("john.doe@example.com");

        ResponseEntity<ReservationDetail> reservationResponse = http.postForEntity(
                acceptOfferUrl, acceptOfferRequest, ReservationDetail.class
        );

        var reservationDetail = reservationResponse.getBody();

        assertThat(addProductResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(offerResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(reservationResponse.getStatusCode()).isEqualTo(HttpStatus.OK);

        assertThat(reservationDetail.getPaymentUrl()).isNotBlank();
        assertThat(reservationDetail.getReservationId()).isNotBlank();


    }

    private String asBaseURL(String addToCartUri) {
        return String.format("http://localhost:%s/%s", port, addToCartUri);
    }

    private String thereIsProduct(String name, BigDecimal price) {
        var id = catalog.addProduct(name, name);
        catalog.changePrice(id, price);

        return id;
    }


}

