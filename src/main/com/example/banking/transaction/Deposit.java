package com.example.banking.transaction;

import com.example.banking.Balance;

public class Deposit extends Transaction {
    private Deposit(String date, int amount) {
        super(date, amount);
    }

    public static Deposit create(String date, int amount) {
        return new Deposit(date, amount);
    }

    @Override
    public Balance perform(Balance currentBalance) {
        return currentBalance.add(amount);
    }
}
