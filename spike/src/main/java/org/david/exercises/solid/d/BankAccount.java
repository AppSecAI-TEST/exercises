package org.david.exercises.solid.d;

/**
 * Created by David Marques on 24/05/2017.
 */
public class BankAccount {

    private int balance;
    private String accountNumber;

    public BankAccount(int balance, String accountNumber) {
        this.balance = balance;
        this.accountNumber = accountNumber;
    }

    public int getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }


    public void addFunds(int value) {
        balance += value;
    }

    public void removeFunds(int value) {
        balance -= value;
    }
}
