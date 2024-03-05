package pl.wiktoriasadlo.creditcard;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

public class CreditCardTest {
    @Test
    void itAllowsToAssignCredit() {
        //Arrange
        CreditCard card = new CreditCard();

        //Act
        card.assignCreditLimit(BigDecimal.valueOf(1000));
        //Assert
        assert  BigDecimal.valueOf(1000).equals(card.getBalance());
    }
    @Test
    void itAllowsToAssignCreditV2() {
        //Arrange
        CreditCard card = new CreditCard();

        //Act
        card.assignCreditLimit(BigDecimal.valueOf(1200));
        //Assert
        assert  BigDecimal.valueOf(1000).equals(card.getBalance());
    }

    @Test
    void itDenyCreditBelowThreshold() {
        CreditCard card = new CreditCard();
        try{
            card.assignCreditLimit(BigDecimal.valueOf(50));
            fail("Should throw exception");

        }catch(CreditBelowThresholdException e){
            assertTrue(true);
        }

    }
}
