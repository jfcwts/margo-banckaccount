package fr.margo.bankaccount;

import java.util.List;

public interface TransactionLedger {
    void addOperation(BankAccountOperationCommand operation);
    List<BankAccountOperationCommand> getAllAccountOperations(BankAccount bankAccount);
}
