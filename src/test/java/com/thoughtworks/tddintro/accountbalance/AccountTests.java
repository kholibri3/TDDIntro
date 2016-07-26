package com.thoughtworks.tddintro.accountbalance;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class AccountTests {

    private final Account account = new Account(100);

    @Test
    public void shouldIncreaseMyBalanceWhenIDepositMoney(){
        account.depositMoney(50);
        assertThat(account.checkBalance(), is(150));
    }

    @Test
    public void shouldDecreaseMyBalanceWhenIWithdrawMoney(){
        account.withdrawMoney(50);
        assertThat(account.checkBalance(), is(50));
    }

    @Test
    public void shouldNotDecreaseMyBalanceWhenIWithdrawMoneyAndDoNotHaveEnoughToCoverTheWithdrawal(){
        Account otherAccount = new Account(50);
        otherAccount.withdrawMoney(100);
        assertThat(otherAccount.checkBalance(), is(50));
    }
}
