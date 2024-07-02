package ecommerce.catalog;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.ArrayList;

@RestController
public class ProductCatalogController {
    private final ProductCatalog catalog;
    public ProductCatalogController(ProductCatalog catalog) {
        this.catalog = catalog;
    }

    @GetMapping("/api/products")
    List<Product> getAllProducts(){
        return catalog.allProducts();
    }

    @GetMapping("/api/published-products")
    List<Product> getPublishedProducts() {
        return new ArrayList<>();
    }
}
