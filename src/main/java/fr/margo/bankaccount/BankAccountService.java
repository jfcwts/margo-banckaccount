package fr.margo.bankaccount;

import java.math.BigDecimal;
import java.util.LinkedList;

public interface BankAccountService {

    /**
     * @param account account to credit
     * @param amount of money to put in the account in €
     */
    void depositMoney(BankAccount account, BigDecimal amount);

    /**
     * @param account account to debit
     * @param amount of money to put in the account in €
     */
    void withdrawMoney(BankAccount account, BigDecimal amount);

    /**
     *
     * @return the list of operation
     */
    LinkedList<BankAccountOperation> getOperationHistory(BankAccount account);

}
