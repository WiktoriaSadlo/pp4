package pl.wiktoriasadlo.creditcard;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class HelloTest {
    @Test
    void helloTest() {
        //Arrange / Given
        var a = 2;
        var b = 4;
        //Act / When
        var result = a+b;
        //Assert / Then / Expected
        assert  6 == result;

    }

    @Test
    void itGreetUsername() {
        String name = "Wiktoria";

        String message = String.format("Hello %s",name);

        assertEquals("Hello Wiktoria", message);
    }

}
