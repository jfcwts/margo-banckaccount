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
        System.out.println(String.format("%s account with balance %s", account1.getId(), account1.getBalance()));
        BankAccount account2 = BankAccountFactory.create();
        System.out.println(String.format("%s account with balance %s", account2.getId(), account2.getBalance()));

        BankAccountService service = BankAccountServiceFactory.create();


        service.depositMoney(account1, new BigDecimal("55.30"));
        System.out.println(String.format("%s account with balance %s", account1.getId(), account1.getBalance()));
        service.withdrawMoney(account1, new BigDecimal("20.00"));
        System.out.println(String.format("%s account with balance %s", account1.getId(), account1.getBalance()));
        service.getOperationHistory(account1).stream().forEach(System.out::println);

        System.out.println(String.format("%s account with balance %s", account2.getId(), account2.getBalance()));
        service.getOperationHistory(account2).stream().forEach(System.out::println);
        service.depositMoney(account2, new BigDecimal("47.10"));
        System.out.println(String.format("%s account with balance %s", account2.getId(), account2.getBalance()));
        service.withdrawMoney(account2, new BigDecimal("20.10"));
        System.out.println(String.format("%s account with balance %s", account2.getId(), account2.getBalance()));
        service.getOperationHistory(account2).stream().forEach(System.out::println);
        try{
            service.withdrawMoney(account2, new BigDecimal("100.00"));
            System.out.println(String.format("%s account with balance %s", account2.getId(), account2.getBalance()));
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

    }
}