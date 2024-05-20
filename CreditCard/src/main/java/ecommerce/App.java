package ecommerce;

import ecommerce.catalog.ArrayListProductStorage;
import ecommerce.catalog.ProductCatalog;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ecommerce.sales.SalesFacade;

import java.math.BigDecimal;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        System.out.println("Here we go!!!");
        SpringApplication.run(App.class, args);
    }

    @Bean
    SalesFacade createSalesFacade(){
        return new SalesFacade();
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
