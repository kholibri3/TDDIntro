package com.thoughtworks.tddintro.accountbalance;

/**
 * Created by Katie on 7/21/16.
 */
public class Account {
    private int balance;

    public Account(int balance) {
        this.balance = balance;
    }

    public void depositMoney(int depositAmount) {
        balance+=depositAmount;
    }

    public void withdrawMoney(int withdrawalAmount) {
        if((balance-withdrawalAmount)>0)
            balance-=withdrawalAmount;
    }

    public int checkBalance() {
       return balance;
    }

}
