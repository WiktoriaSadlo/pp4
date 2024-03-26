package ecommerce;

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
    ecommerce.ProductCatalog createMyCatalog() {
        var catalog = new ecommerce.ProductCatalog();
        catalog.addProduct("Lego set 8083", "Nice one");
        catalog.addProduct("Cobi Bricks","Nice one");
        return catalog;
    }
}
