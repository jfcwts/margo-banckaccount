package fr.margo.bankaccount;

import java.math.BigDecimal;

public class BankAccountFactory {
    public static BankAccount create() {
        BigDecimal initialBalance = new BigDecimal("0.0");
        BankAccount account = new BankAccountImpl (initialBalance);
        System.out.println(String.format("Bank account (%s) created with initial balance at (%s)", account.getId(), initialBalance));
        return account;
    }
}
