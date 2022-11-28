package fr.margo.bankaccount;

import java.math.BigDecimal;
import java.util.List;

public class BankAccountServiceImpl implements  BankAccountService{

    private final TransactionLedger ledger;

    public BankAccountServiceImpl(TransactionLedger ledger){
        this.ledger = ledger;
    }

    @Override
    public void depositMoney(BankAccount account, BigDecimal amount) {
        if(amount.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("the amount must be positive");
        }
        changeBalance(account, OperationType.DEPOSIT, amount);
    }

    @Override
    public void withdrawMoney(BankAccount account, BigDecimal amount) {
        if(amount.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("the amount must be positive");
        }
        if(account.getBalance().compareTo(amount) < 0) {
            throw new IllegalArgumentException("Not enough on the account to without that amount");
        }
        changeBalance(account, OperationType.WITHDRAWAL, amount.negate());
    }

    private void changeBalance(BankAccount account, OperationType operationType, BigDecimal amount) {

        if(amount.compareTo(BigDecimal.ZERO) == 0){
            return;
        }

        BankAccountOperationCommand deposit = new BankAccountOperationCommandImp(
                account,
                operationType,
                amount);

        deposit.execute();
        ledger.addOperation(deposit);
    }

    @Override
    public List<BankAccountOperationCommand> getOperationHistory(BankAccount account) {
        return ledger.getAllAccountOperations(account);
    }
}
