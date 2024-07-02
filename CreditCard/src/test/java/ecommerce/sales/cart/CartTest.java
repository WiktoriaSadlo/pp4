package ecommerce.sales.cart;

import ecommerce.sales.cart.Cart;
import ecommerce.sales.cart.CartItem;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CartTest {
    public static final String PRODUCT_1 = "lego-8297";
    public static final String PRODUCT_2 = "lego-8298";

    @Test
    void newCartIsEmpty() {
        Cart cart = Cart.empty();

        assertThat(cart.isEmpty()).isTrue();
    }

    @Test
    void notEmptyWhenProductAdded() {
        Cart cart = Cart.empty();
        String productId = thereIsProduct(PRODUCT_1);

        cart.addProduct(productId);

        assertThat(cart.isEmpty()).isFalse();

    }


    @Test
    void cartConsiderSameProductAsSingleItem() {
        Cart cart = Cart.empty();
        String productId = thereIsProduct(PRODUCT_1);

        cart.addProduct(productId);
        assertThat(cart.getItemsCount()).isEqualTo(1);
    }

    @Test
    void cartConsiderSameProductAsSingleItemS2() {
        Cart cart = Cart.empty();
        String productId = thereIsProduct(PRODUCT_1);

        cart.addProduct(productId);
        cart.addProduct(productId);

        assertThat(cart.getItemsCount()).isEqualTo(1);
    }


    @Test
    void cartConsiderSameProductAsSingleItemS3() {
        Cart cart = Cart.empty();
        String productX = thereIsProduct(PRODUCT_1);
        String productY = thereIsProduct(PRODUCT_2);

        cart.addProduct(productX);
        cart.addProduct(productY);

        assertThat(cart.getItemsCount()).isEqualTo(2);
    }


    @Test
    void exposeProductQuantityWithCartLineS1 () {
        Cart cart = Cart.empty();
        String productId = thereIsProduct(PRODUCT_1);

        cart.addProduct(productId);

        List<CartItem> cartItems = cart.getCartItems();

        assertCartLinesContainsProductWithNQuantity(cartItems,productId,1);
    }

    private void assertCartLinesContainsProductWithNQuantity(List<CartItem> cartItems, String product1, int expectedQuantity){
        assertThat(cartItems)
                .filteredOn(cartItem -> cartItem.getProductId().equals(product1))
                .extracting(CartItem::getQuantity)
                .first()
                .isEqualTo(expectedQuantity)
        ;
    }

    private String thereIsProduct(String id) {
        return id;
    }
}
