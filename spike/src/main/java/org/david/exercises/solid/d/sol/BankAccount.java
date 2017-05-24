package org.david.exercises.solid.d.sol;

/**
 * Created by David Marques on 24/05/2017.
 */
public final class BankAccount implements ITransferSource, ITransferDestination {

    private final String accountNumber;
    private int balance;

    public BankAccount(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public BankAccount(String accountNumber, int balance) {
        this(accountNumber);
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public int getBalance() {
        return balance;
    }

    @Override
    public void removeFunds(int value) {
        this.balance -= value;
    }

    @Override
    public void addFunds(int value) {
        this.balance += value;
    }
}
