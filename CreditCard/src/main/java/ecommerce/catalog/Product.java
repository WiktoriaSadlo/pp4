package ecommerce.catalog;

import java.math.BigDecimal;
import java.util.UUID;

public class Product {
    private String id;
    private String name;
    private String description;
    private BigDecimal price;

    public Product(UUID id,String name, String description, BigDecimal price) {
        this.id = id.toString();
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public Product(UUID id, String name, String description) {
        this.id = id.toString();
        this.name = name;
        this.description = description;
    }

     Product() {

    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getId() {
        return id;
    }

    public void changePrice(BigDecimal newPrice){
        this.price = newPrice;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }
}
