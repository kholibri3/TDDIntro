package com.thoughtworks.tddintro.accountbalance;

/**
 * Created by Katie on 7/21/16.
 */
public class Account {
    private int balance;

    public Account(int balance) {
        this.balance = balance;
    }

    // returns new balance after deposit
    public int depositMoney(int d) {
        return balance+d;
    }

    // returns new balance after withdrawal, unless it will overdraw your funds, then just return the old balance
    public int withdrawMoney(int w) {
        if((balance-w)>0)
            return balance-w;
        return balance;
    }
}
