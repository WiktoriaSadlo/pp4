package pl.wiktoriasadlo.creditcard;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;


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
    void itDenyCreditBelowThresholdV1() {
        CreditCard card = new CreditCard();
        assertThrows(
                CreditBelowThresholdException.class,
                () -> card.assignCreditLimit(BigDecimal.valueOf(50))
        );

    }
    @Test
    void itDenyCreditBelowThresholdV2() {
    CreditCard card = new CreditCard();
    assertThrows(
            CreditBelowThresholdException.class,
            () -> card.assignCreditLimit(BigDecimal.valueOf(100))
    );

    }

    @Test
    void itDenyCreditReassignment() {
        CreditCard card = new CreditCard();
        card.assignCreditLimit(BigDecimal.valueOf(1000));

        assertThrows(
                CantReassignException.class,
                () -> card.assignCreditLimit(BigDecimal.valueOf(1200))
        );
    }

    @Test
    void payForSomething() {
        CreditCard card = new CreditCard();
        card.assignCreditLimit(BigDecimal.valueOf(1000));
        card.pay(BigDecimal.valueOf(100));

        assertEquals(
                BigDecimal.valueOf(900),
                card.getBalance()
        );
    }

    @Test
    void itDenyPaymentWhenNotEnoughMoney() {
        CreditCard card = new CreditCard();
        card.assignCreditLimit(BigDecimal.valueOf(1000));
        card.pay(BigDecimal.valueOf(900));

        assertThrows(
                NotEnoughMoneyException.class,
                () -> card.pay(BigDecimal.valueOf(200))
        );
    }



}
