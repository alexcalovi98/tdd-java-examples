package com.example.banking.registry;

import com.example.banking.Balance;
import com.example.banking.transaction.Transaction;

import java.util.ArrayList;
import java.util.List;

public class TransactionRegistry {

    private static final List<TransactionRegistryEntry> transactionRegistryEntries = new ArrayList<>();

    public static Balance perform(Transaction transaction, Balance currentBalance) {
        Balance balanceAfterTransaction = transaction.perform(currentBalance);
        transactionRegistryEntries.add(TransactionRegistryEntry.of(transaction, balanceAfterTransaction));
        return balanceAfterTransaction;
    }

    public static List<TransactionRegistryEntry> retrieveTransactions() {
        return new ArrayList<>(transactionRegistryEntries);
    }

    public static void clear() {
        transactionRegistryEntries.clear();
    }
}
