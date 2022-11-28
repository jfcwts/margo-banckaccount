package fr.margo.bankaccount;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

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
     * @param account
     * @return the list of operation in chronogical order for this account
     */
    List<BankAccountOperationCommand> getOperationHistory(BankAccount account);

}
