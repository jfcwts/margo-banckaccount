package fr.margo.bankaccount;

import fr.margo.utils.Command;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public interface BankAccountOperationCommand extends Command {


    BankAccount getBankAccount();
    OperationType getOperation();
    BigDecimal getAmount();
    BigDecimal getBalanceAfterExecution();
    LocalDateTime getExecutionDatetime();
}
