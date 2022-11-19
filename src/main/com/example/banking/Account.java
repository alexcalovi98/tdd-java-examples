package com.example.banking;

import com.example.banking.registry.TransactionRegistry;
import com.example.banking.registry.TransactionRegistryEntry;
import com.example.banking.transaction.Deposit;
import com.example.banking.transaction.Withdraw;

import java.util.Collections;
import java.util.List;

public class Account {
    private Balance balance;

    public Account(Balance balance) {
        this.balance = balance;
    }

    public Balance deposit(String date, int amount){
        balance = TransactionRegistry.perform(Deposit.create(date, amount), balance);
        return balance;
    }

    public Balance withdraw(String date, int amount){
        balance = TransactionRegistry.perform(Withdraw.create(date, amount), balance);
        return balance;
    }

    public String printStatement(){
        StringBuilder sb = new StringBuilder();
        sb.append(printHeader());
        String newline = "";
        List<TransactionRegistryEntry> entries = TransactionRegistry.retrieveTransactions();
        Collections.reverse(entries);
        for(TransactionRegistryEntry entry : entries){
            sb.append(newline);
            sb.append(entry.toString());
            newline = "\n";
        }
        return sb.toString();
    }

    private String printHeader(){
        return "DATE | AMOUNT | BALANCE\n";
    }
}
