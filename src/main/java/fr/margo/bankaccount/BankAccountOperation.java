package fr.margo.bankaccount;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public interface BankAccountOperation {
    enum Operation {
        DEPOSIT,
        WITHDRAWAL
    }

    Operation getOperation();
    BigDecimal getAmount();
    BigDecimal getBalance();
    LocalDateTime getExecutionDate();
}
