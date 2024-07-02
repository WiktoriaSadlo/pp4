package ecommerce.sales.offering;

import ecommerce.sales.offering.Offer;
import ecommerce.sales.offering.OfferCalculator;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Collections;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class OfferCalculatorTest {
    @Test
    void zeroOfferForEmptyItems() {
        OfferCalculator calculator = new OfferCalculator();

        Offer offer = calculator.calculate(Collections.emptyList());

        assertThat(offer.getTotal()).isEqualTo(BigDecimal.ZERO);
    }

}
