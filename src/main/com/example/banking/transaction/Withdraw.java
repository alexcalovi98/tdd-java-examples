package com.example.banking.transaction;

import com.example.banking.Balance;

public class Withdraw extends Transaction {

    private Withdraw(String date, int amount) {
        super(date, amount);
    }

    public static Withdraw create(String date, int amount) {
        return new Withdraw(date, amount);
    }

    @Override
    String formatAmount() {
        return "-" + amount;
    }

    @Override
    public Balance perform(Balance currentBalance) {
        return currentBalance.remove(amount);
    }
}
