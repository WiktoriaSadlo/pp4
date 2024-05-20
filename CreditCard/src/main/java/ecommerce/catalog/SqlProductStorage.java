package ecommerce.catalog;

import java.util.List;
import java.util.S

public class SqlProductStorage implements ProductStorage {

    SqlList<String, Product> productSql;


    public SqlProductStorage(SqlList<String, Product> productSql) {
        this.productSql = productSql;
    }

    @Override
    public List<Product> allProducts() {
        return productSql.values().stream().toList();
    }

    @Override
    public void add(Product product) {
        productSql.put(product.getId(), product);
    }

    @Override
    public Product getProductBy(String id) {
        return productSql.get(id);
    }
}
