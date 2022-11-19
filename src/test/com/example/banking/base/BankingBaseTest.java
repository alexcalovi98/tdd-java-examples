package com.example.banking.base;

import com.example.banking.registry.TransactionRegistry;
import org.junit.After;

public class BankingBaseTest {

    @After
    public void tearDown() {
        TransactionRegistry.clear();
    }
}
