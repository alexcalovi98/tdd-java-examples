package com.example.banking.transaction;

import org.junit.Assert;
import org.junit.Test;

public class TransactionTest {

    @Test
    public void testEqualsDeposit(){
        Deposit expectedDeposit = Deposit.create("20/04/2014", 500);
        Assert.assertEquals(expectedDeposit, Deposit.create("20/04/2014", 500));
        Assert.assertNotEquals(expectedDeposit, Deposit.create("20/04/2016", 500));
    }

    @Test
    public void testEqualsWithdraw(){
        Withdraw expectedWithdraw = Withdraw.create("20/04/2014", 500);
        Assert.assertEquals(expectedWithdraw, Withdraw.create("20/04/2014", 500));
    }
}
