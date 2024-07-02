package ecommerce.sales.cart;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Cart {
    Map<String, Integer> productsQty;

    public Cart(){
        this.productsQty = new HashMap<>();
    }

    public static Cart empty() {
        return new Cart();
    }

    public void addProduct(String productId) {
        if (!isInCart(productId)){
            addToCart(productId);
        } else{
            increaseQuantity(productId);
        }
    }

    private boolean isInCart(String productId){
        return productsQty.containsKey(productId);
    }

    private void addToCart(String productId){
        productsQty.put(productId, 1);
    }

    private void increaseQuantity(String productId) {
        productsQty.put(productId, productsQty.get(productId) +1);
    }

    public boolean isEmpty() {
        return productsQty.isEmpty();
    }

    public int getItemsCount() {
        return productsQty.size();
    }

    public List<CartItem> getCartItems() {
        return productsQty.entrySet()
                .stream()
                .map(es -> new CartItem(es.getKey(), es.getValue()))
                .collect(Collectors.toList());
    }
}

