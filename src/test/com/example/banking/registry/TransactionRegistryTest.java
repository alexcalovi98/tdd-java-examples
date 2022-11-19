package com.example.banking.registry;

import com.example.banking.Balance;
import com.example.banking.base.BankingBaseTest;
import com.example.banking.transaction.Deposit;
import com.example.banking.transaction.Withdraw;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class TransactionRegistryTest extends BankingBaseTest {

    @Test
    public void testPerformTransaction(){
        Deposit deposit = Mockito.mock(Deposit.class);
        Balance currentBalance = Balance.valueOf(1000);
        Balance expectedBalanceAfterTransaction = Mockito.mock(Balance.class);

        Mockito.when(deposit.perform(currentBalance)).thenReturn(expectedBalanceAfterTransaction);

        Balance balanceAfterTransaction = TransactionRegistry.perform(deposit, currentBalance);

        Assert.assertEquals(expectedBalanceAfterTransaction, balanceAfterTransaction);
    }

    @Test
    public void testRetrieveTransactions(){
        Balance currentBalance = Mockito.mock(Balance.class);

        Deposit deposit = Mockito.mock(Deposit.class);
        Balance balanceAfterDepositTransaction = Mockito.mock(Balance.class);
        Mockito.when(deposit.perform(currentBalance)).thenReturn(balanceAfterDepositTransaction);

        Withdraw withdraw = Mockito.mock(Withdraw.class);
        Balance balanceAfterWithDrawTransaction = Mockito.mock(Balance.class);
        Mockito.when(withdraw.perform(currentBalance)).thenReturn(balanceAfterWithDrawTransaction);

        TransactionRegistry.perform(deposit, currentBalance);
        TransactionRegistry.perform(withdraw, currentBalance);

        List<TransactionRegistryEntry> transactionRegistryEntries = new ArrayList<>(2);
        transactionRegistryEntries.add(TransactionRegistryEntry.of(deposit, balanceAfterDepositTransaction));
        transactionRegistryEntries.add(TransactionRegistryEntry.of(withdraw, balanceAfterWithDrawTransaction));

        Assert.assertEquals(transactionRegistryEntries, TransactionRegistry.retrieveTransactions());
    }
}
