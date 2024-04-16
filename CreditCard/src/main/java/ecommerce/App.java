package ecommerce;

import ecommerce.catalog.ProductCatalog;
import ecommerce.catalog.ProductStorage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class App {

    public static void main(String[] args) {
        System.out.println("Here we go!!!");
        SpringApplication.run(App.class, args);
    }

    @Bean
    ProductCatalog createMyCatalog() {
        var catalog = new ProductCatalog(productStorage);
        catalog.addProduct("Lego set 8083", "Nice one");
        catalog.addProduct("Cobi Bricks","Nice one");
        return catalog;
    }
}
