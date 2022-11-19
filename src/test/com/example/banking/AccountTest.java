package com.example.banking;

import com.example.banking.base.BankingBaseTest;
import com.example.banking.transaction.Deposit;
import com.example.banking.transaction.Withdraw;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;

public class AccountTest extends BankingBaseTest {

    private final Balance initialAccountBalance = Balance.valueOf(1000);

    @Test
    public void testDeposit(){
        Account account = new Account(initialAccountBalance);
        Balance balanceAfterTransaction = Mockito.mock(Balance.class);

        Deposit deposit = Mockito.mock(Deposit.class);
        Mockito.when(deposit.perform(initialAccountBalance)).thenReturn(balanceAfterTransaction);

        try (MockedStatic<Deposit> depositMockedStatic = Mockito.mockStatic(Deposit.class)) {
            depositMockedStatic.when(() -> Deposit.create("10/04/2014", 500)).thenReturn(deposit);
            Assert.assertEquals(balanceAfterTransaction, account.deposit("10/04/2014", 500));
        }
    }

    @Test
    public void testWithdraw(){
        Account account = new Account(initialAccountBalance);
        Balance balanceAfterTransaction = Mockito.mock(Balance.class);

        Withdraw withdraw = Mockito.mock(Withdraw.class);
        Mockito.when(withdraw.perform(initialAccountBalance)).thenReturn(balanceAfterTransaction);

        try (MockedStatic<Withdraw> withdrawMockedStatic = Mockito.mockStatic(Withdraw.class)) {
            withdrawMockedStatic.when(() -> Withdraw.create("10/04/2014", 500)).thenReturn(withdraw);
            Assert.assertEquals(balanceAfterTransaction, account.withdraw("10/04/2014", 500));
        }
    }

    @Test
    public void testPrintStatement(){
        Account account = new Account(initialAccountBalance);
        account.withdraw("02/04/2014", 100);
        account.deposit("10/04/2014", 500);
        String expectedOutput =
            "DATE | AMOUNT | BALANCE\n" +
            "10/04/2014 | 500 | 1400\n" +
            "02/04/2014 | -100 | 900";
        Assert.assertEquals(expectedOutput, account.printStatement());
    }


}
