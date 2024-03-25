package pl.wiktoriasadlo.creditcard;

import java.math.BigDecimal;

public class CreditCard {
    private  BigDecimal creditLimit;
    private BigDecimal balance;
    //public static final int CREDIT_MIN_THRESHOLD = 100;


    public void assignCreditLimit(BigDecimal creditLimit) {
        if (isCreditAlreadyAssigned()) {
            throw new InsufficientFoundsExceptions();
        }
        if (isCreditBelowThreshold(creditLimit)) {
            throw new CreditBelowThresholdException();
        }
        this.creditLimit = creditLimit;
        this.balance = this.creditLimit;

    }

    private boolean isCreditAlreadyAssigned() {
        return this.creditLimit != null;
    }

    private static boolean isCreditBelowThreshold(BigDecimal creditLimit) {
        return BigDecimal.valueOf(100).compareTo(creditLimit) > 0;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void pay(BigDecimal money) {
        if (!canAfford(money)){
            throw new NotEnoughMoneyException();
        }
        this.balance=this.balance.subtract(money);
    }

    private boolean canAfford(BigDecimal money) {
        return this.balance.subtract(money).compareTo(BigDecimal.ZERO)>0;
    }
}
