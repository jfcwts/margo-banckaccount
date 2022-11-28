package fr.margo.bankaccount;

import java.math.BigDecimal;
import java.util.UUID;

public class BankAccountImpl implements  BankAccount{
    private BigDecimal balance;
    private UUID uuid;
    public BankAccountImpl (BigDecimal balance){
        this.balance = balance;
        this.uuid = UUID.randomUUID();
    }

    @Override
    public UUID getId() {
        return this.uuid;
    }

    @Override
    public BigDecimal getBalance() {
        return balance;
    }

    @Override
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    @Override
    public void addAmount(BigDecimal amount) {
        this.balance = this.balance.add(amount);
    }

}
