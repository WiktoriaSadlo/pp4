package ecommerce;

import ecommerce.catalog.ArrayListProductStorage;
import ecommerce.catalog.ProductCatalog;
import ecommerce.payu.*;
import ecommerce.sales.cart.CartStorage;
import ecommerce.sales.offering.OfferCalculator;
import ecommerce.sales.payment.PaymentDetails;
import ecommerce.sales.payment.PaymentGateway;
import ecommerce.sales.payment.RegisterPaymentRequest;
import ecommerce.sales.reservation.ReservationRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ecommerce.sales.SalesFacade;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        System.out.println("Here we go!!!");
        SpringApplication.run(App.class, args);
    }

    @Bean
    SalesFacade createSales() {
        return new SalesFacade(
                new CartStorage(),
                new OfferCalculator(),
                new PayUPaymentGw() {
                    @Override
                    public PaymentDetails registerPayment(RegisterPaymentRequest registerPaymentRequest) {
                        return null;
                    }
                },
                new ReservationRepository()
        );
    }
    @Bean
    ProductCatalog createMyCatalog() {
        var catalog = new ProductCatalog(new ArrayListProductStorage());
        var pid1 = catalog.addProduct("Lego set 8083", "nice one");
        catalog.changePrice(pid1, BigDecimal.valueOf(100.10));

        var pid2 = catalog.addProduct("Cobi set 8083", "nice one");
        catalog.changePrice(pid2, BigDecimal.valueOf(50.10));

        return catalog;
    }


}
