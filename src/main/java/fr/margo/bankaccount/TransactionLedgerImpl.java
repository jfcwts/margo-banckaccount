package fr.margo.bankaccount;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Not thread safe...
 */
public class TransactionLedgerImpl implements TransactionLedger {

    private List<BankAccountOperationCommand> ledger = new LinkedList<BankAccountOperationCommand>();

    protected TransactionLedgerImpl(){}

    public void  addOperation(BankAccountOperationCommand operation) {
        ledger.add(operation);
    }

    public List<BankAccountOperationCommand> getAllAccountOperations(BankAccount bankAccount) {
        return ledger.stream()
                .filter((op) -> op.getBankAccount().getId() == bankAccount.getId())
                .collect(Collectors.toList());
    }
}
