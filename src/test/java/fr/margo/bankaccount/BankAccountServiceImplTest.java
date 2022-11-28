package fr.margo.bankaccount;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BankAccountServiceImplTest {
    private BankAccount account;
    private BankAccount account2;
    private BankAccountService service;

    @BeforeEach
    public void init(){
        service = BankAccountServiceFactory.create();
        account = BankAccountFactory.create();
        assertEquals(account.getBalance(), new BigDecimal("0.0"));
        account2 = BankAccountFactory.create();
        assertEquals(account2.getBalance(), new BigDecimal("0.0"));
    }

    @Test
    public void depositMoney() {
        service.depositMoney(account, new BigDecimal("20.00"));
        assertEquals(account.getBalance(), new BigDecimal("20.00"));
        service.depositMoney(account, new BigDecimal("30.50"));
        assertEquals(account.getBalance(), new BigDecimal("50.50"));
        assertThrows(IllegalArgumentException.class, () -> service.depositMoney(account, new BigDecimal("-2")));
    }

    @Test
    public void withdrawMoney() {
        account.setBalance(new BigDecimal("50"));
        service.withdrawMoney(account, new BigDecimal("17"));
        assertEquals(account.getBalance(), new BigDecimal("33"));
        service.withdrawMoney(account, new BigDecimal("33"));
        assertEquals(account.getBalance(), new BigDecimal(0));

        account.setBalance(new BigDecimal("50"));
        assertThrows(IllegalArgumentException.class, () -> service.withdrawMoney(account, new BigDecimal("60")));
        assertThrows(IllegalArgumentException.class, () -> service.withdrawMoney(account, new BigDecimal("-2")));
    }

    @Test
    public void getOperationHistory() {
        List<BankAccountOperationCommand> operations = service.getOperationHistory(account);
        assertEquals(operations.size(), 0);

        service.depositMoney(account, new BigDecimal("50"));
        service.depositMoney(account2, new BigDecimal("60"));
        service.withdrawMoney(account, new BigDecimal("17"));
        service.depositMoney(account, new BigDecimal("22"));

        operations = service.getOperationHistory(account);
        assertEquals(operations.size(), 3);
        assertEquals(operations.get(0).getBalanceAfterExecution(), new BigDecimal("50.0"));
        assertEquals(operations.get(1).getBalanceAfterExecution(), new BigDecimal("33.0"));
        assertEquals(operations.get(2).getBalanceAfterExecution(), new BigDecimal("55.0"));

        LocalDate currentDate = LocalDate.now();
        assertEquals(operations.get(0).getExecutionDatetime().toLocalDate(), currentDate);
        assertEquals(operations.get(1).getExecutionDatetime().toLocalDate(), currentDate);
        assertEquals(operations.get(2).getExecutionDatetime().toLocalDate(), currentDate);

    }
}
