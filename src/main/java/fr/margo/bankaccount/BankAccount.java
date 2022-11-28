package fr.margo.bankaccount;

import java.math.BigDecimal;
import java.util.UUID;

public interface BankAccount {

    UUID getId();
    BigDecimal getBalance();
    void setBalance(BigDecimal balance);
    void addAmount(BigDecimal amount);
}
