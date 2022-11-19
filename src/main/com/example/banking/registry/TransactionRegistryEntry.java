package com.example.banking.registry;

import com.example.banking.Balance;
import com.example.banking.transaction.Transaction;

import java.util.Objects;

public class TransactionRegistryEntry {
    private final Transaction transaction;
    private final Balance balance;

    private TransactionRegistryEntry(Transaction transaction, Balance balance) {
        this.transaction = transaction;
        this.balance = balance;
    }

    public static TransactionRegistryEntry of(Transaction transaction, Balance balance) {
        return new TransactionRegistryEntry(transaction, balance);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransactionRegistryEntry that = (TransactionRegistryEntry) o;
        return transaction.equals(that.transaction) && balance.equals(that.balance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transaction, balance);
    }

    @Override
    public String toString() {
        return transaction.toString() + " | " + balance.toString();
    }
}
