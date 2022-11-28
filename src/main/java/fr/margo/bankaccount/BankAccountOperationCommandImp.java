package fr.margo.bankaccount;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class BankAccountOperationCommandImp implements BankAccountOperationCommand{
    private BankAccount bankAccountReceiver;
    private OperationType operation;
    private BigDecimal amount;
    private BigDecimal balanceAfterExecution;
    private LocalDateTime executionDatetime;

    public BankAccountOperationCommandImp(BankAccount receiver, OperationType operation, BigDecimal amount) {
        this.bankAccountReceiver = receiver;
        this.operation = operation;
        this.amount = amount;
        this.balanceAfterExecution = null;
        this.executionDatetime = null;
    }

    @Override
    public void execute() {
        this.bankAccountReceiver.addAmount(amount);
        this.balanceAfterExecution = this.bankAccountReceiver.getBalance();
        this.executionDatetime = LocalDateTime.now();
    }

    @Override
    public void unExecute() {
        throw new UnsupportedOperationException();
    }

    @Override
    public BankAccount getBankAccount() {
        return bankAccountReceiver;
    }

    @Override
    public OperationType getOperation() {
        return operation;
    }

    @Override
    public BigDecimal getAmount() {
        return amount;
    }

    @Override
    public BigDecimal getBalanceAfterExecution() {
        return balanceAfterExecution;
    }

    @Override
    public LocalDateTime getExecutionDatetime() {
        return executionDatetime;
    }

    @Override
    public String toString(){
        return String.format("Operation of (%s) done at (%s) for a amount of (%s) leading to a balance if (%s)",
            this.operation,
            this.executionDatetime,
            this.amount,
                this.balanceAfterExecution
        );
    }


}
