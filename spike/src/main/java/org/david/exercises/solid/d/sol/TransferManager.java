package org.david.exercises.solid.d.sol;

/**
 * Created by David Marques on 24/05/2017.
 * TransferManager now depends on Abstraction that does not depend on detail. DIP
 */
public final class TransferManager {
    private final ITransferStrategy transferStrategy;

    public TransferManager(ITransferStrategy transferStrategy) {
        this.transferStrategy = transferStrategy;
    }

    public void transfer(final ITransferSource source, final ITransferDestination destination, final int value) {
        transferStrategy.transfer(source, destination, value);
    }
}
