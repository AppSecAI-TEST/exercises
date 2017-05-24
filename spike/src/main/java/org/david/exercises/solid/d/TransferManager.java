package org.david.exercises.solid.d;

/**
 * Created by David Marques on 24/05/2017.
 */
public class TransferManager {

    private BankAccount source;
    private BankAccount destination;
    private int value;

    public BankAccount getSource() {
        return source;
    }

    public void setSource(BankAccount source) {
        this.source = source;
    }

    public BankAccount getDestination() {
        return destination;
    }

    public void setDestination(BankAccount destination) {
        this.destination = destination;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void transfer() {
        source.removeFunds(value);
        destination.addFunds(value);
    }
}
