package pl.wiktoriasadlo.creditcard;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class NumberRepresentationTest {

    @Test
    void testDouble() {
        double a = 0.03;
        double b = 0.02;

        System.out.println("Double: ");
        System.out.println(a-b);
    }

    @Test
    void testFloat() {
        float a = 0.03f;
        float b = 0.02f;

        System.out.println("Float: ");
        System.out.println(a-b);
    }

    @Test
    void testBigDecimal() {
        BigDecimal a = new BigDecimal("0.002");
        BigDecimal b = new BigDecimal("0.003");


        System.out.println("Big Decimal: ");
        System.out.println(a.subtract(b));
    }

}
