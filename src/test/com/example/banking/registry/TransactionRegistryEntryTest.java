package com.example.banking.registry;

import com.example.banking.Balance;
import com.example.banking.transaction.Deposit;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class TransactionRegistryEntryTest {

    @Test
    public void testTransactionRegistryEntryEquals(){
        Deposit deposit = Mockito.mock(Deposit.class);
        Balance balance = Mockito.mock(Balance.class);
        TransactionRegistryEntry expectedEntry = TransactionRegistryEntry.of(deposit, balance);
        TransactionRegistryEntry entry = TransactionRegistryEntry.of(deposit, balance);
        Assert.assertEquals(expectedEntry, entry);
    }

    @Test
    public void testTransactionRegistryEntryToString(){
        Deposit deposit = Mockito.mock(Deposit.class);
        Mockito.when(deposit.toString()).thenReturn("20/04/2014 | 500");
        Balance balance = Mockito.mock(Balance.class);
        Mockito.when(balance.toString()).thenReturn("1500");

        TransactionRegistryEntry entry = TransactionRegistryEntry.of(deposit, balance);
        Assert.assertEquals("20/04/2014 | 500 | 1500", entry.toString());
    }
}
