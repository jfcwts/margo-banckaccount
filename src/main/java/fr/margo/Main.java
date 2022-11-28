package fr.margo;

import fr.margo.bankaccount.BankAccount;
import fr.margo.bankaccount.BankAccountFactory;
import fr.margo.bankaccount.BankAccountService;
import fr.margo.bankaccount.BankAccountServiceFactory;

import java.math.BigDecimal;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        BankAccount account1 = BankAccountFactory.create();
        BankAccount account2 = BankAccountFactory.create();

        BankAccountService service = BankAccountServiceFactory.create();


        service.depositMoney(account1, new BigDecimal("55.30"));
        service.withdrawMoney(account1, new BigDecimal("20.00"));
        service.getOperationHistory(account1).stream().forEach(System.out::println);

        service.getOperationHistory(account2).stream().forEach(System.out::println);
        service.depositMoney(account2, new BigDecimal("47.10"));
        service.withdrawMoney(account2, new BigDecimal("20.10"));
        service.getOperationHistory(account2).stream().forEach(System.out::println);
        try{
            service.withdrawMoney(account2, new BigDecimal("100.00"));
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

    }
}