package fr.margo.bankaccount;

import java.math.BigDecimal;

public class BankAccountFactory {
    public static BankAccount create() {
        return new BankAccountImpl (new BigDecimal("0.0"));
    }
}
