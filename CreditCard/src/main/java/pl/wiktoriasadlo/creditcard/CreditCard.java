package pl.wiktoriasadlo.creditcard;

import java.math.BigDecimal;

public class CreditCard {
    private  BigDecimal creditLimit;
    private BigDecimal balans;
    public static final int CREDIT_MIN_THRESHOLD = 100;


    public void assignCreditLimit(BigDecimal creditLimit) {
        if (this.creditLimit != null) {
            throw new InsufficientFoundsExceptions();
        }
        if (BigDecimal.valueOf(100).compareTo(creditLimit) > 0) {
            throw new CreditBelowThresholdException();
        }
        this.creditLimit = creditLimit;

    }

    public BigDecimal getBalance() {
        return creditLimit;
    }

    public void pay(BigDecimal money) {
        if(this.balans.subtract(money).compareTo(BigDecimal.ZERO)>0){
            throw new InsufficientFoundsExceptions();
        }
        this.balans=this.balans.subtract(money);
    }
}
