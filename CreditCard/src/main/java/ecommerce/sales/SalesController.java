package ecommerce.sales;

import ecommerce.sales.offering.Offer;
import ecommerce.sales.reservation.AcceptOfferRequest;
import ecommerce.sales.reservation.ReservationDetail;
import org.springframework.web.bind.annotation.*;

@RestController
public class SalesController {
    SalesFacade sales;
    private AcceptOfferRequest request;

    public SalesController(SalesFacade sales) {
        this.sales = sales;
    }

    @PostMapping("/api/add-product/{productId}")
    void addProduct(@PathVariable(name="productId") String productId){
        String customerId = getCurrentCustomer();
        sales.addToCart(customerId,productId);
    }

    @PostMapping("/api/accept-offer")
    ReservationDetail acceptOffer(@RequestBody AcceptOfferRequest request) {
        String customerId = getCurrentCustomer();
        return sales.acceptOffer(customerId, request);
    }

    @GetMapping("/api/current-offer")
    Offer getCurrentOffer(){
        String customerId = getCurrentCustomer();
        return  sales.getCurrentOffer(customerId);
    }

    private String getCurrentCustomer() {
        return "guest";
    }



}