package fr.margo.bankaccount;

public class BankAccountServiceFactory {
    public static BankAccountService create(){
        return new BankAccountServiceImpl();
    }
}
