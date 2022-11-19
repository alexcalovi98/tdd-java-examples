package com.example.banking.transaction;

import com.example.banking.Balance;

import java.util.Objects;

public abstract class Transaction {

    private final String date;
    protected final int amount;

    public Transaction(String date, int amount) {
        this.date = date;
        this.amount = amount;
    }

    public abstract Balance perform(Balance currentBalance);
    String formatAmount() {
        return String.valueOf(amount);
    };


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return amount == that.amount && date.equals(that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, amount);
    }

    @Override
    public String toString() {
        return date + " | " + formatAmount();
    }
}
