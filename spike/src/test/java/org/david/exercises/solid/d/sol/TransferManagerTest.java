package org.david.exercises.solid.d.sol;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * Created by David Marques on 24/05/2017.
 */
public class TransferManagerTest {

    @Test
    public void transferWithClassicStrategy() throws Exception {
        TransferManager transManager = new TransferManager(TransferStrategy.CLASSIC);
        int balance = 1000;
        BankAccount accountA = new BankAccount("111111", balance);
        BankAccount accountB = new BankAccount("111112", balance);
        transManager.transfer(accountA, accountB, accountA.getBalance());
        assertThat(accountA.getBalance()).isEqualTo(0);
        assertThat(accountB.getBalance()).isEqualTo(balance*2);
    }

}