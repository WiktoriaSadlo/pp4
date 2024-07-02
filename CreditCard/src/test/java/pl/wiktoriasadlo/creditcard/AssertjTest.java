package pl.wiktoriasadlo.creditcard;

import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.api.Assertions.*;

public class AssertjTest {
    @Test
    void timeAssert(){
        assertThat(Instant.now())
                .isInThePast();
    }
    @Test
    void helloAssertJ() {
        var hello = "Hello World";

        assertThat(hello).containsOnlyDigits();
    }

    @Test
    void testSomeListExpression() {
        var names = Collections.singleton("Wiktoria");

        assertThat(names)
                .isUnmodifiable()
                .hasSize(3)
                .containsAll(Arrays.asList("Wiktoria", "Daria"));
    }
}
