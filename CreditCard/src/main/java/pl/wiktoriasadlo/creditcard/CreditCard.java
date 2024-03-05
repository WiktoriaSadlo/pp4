package pl.wiktoriasadlo.creditcard;

import java.math.BigDecimal;

public class CreditCard {

    public void assignCreditLimit(BigDecimal creditLimit) {
        this.creditLimit = creditLimit;

    }

    public BigDecimal getBalance() {
        return creditLimit;
    }
}
