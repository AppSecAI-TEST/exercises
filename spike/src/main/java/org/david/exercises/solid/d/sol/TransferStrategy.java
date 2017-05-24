package org.david.exercises.solid.d.sol;

/**
 * Created by David Marques on 24/05/2017.
 */
public enum TransferStrategy implements ITransferStrategy {

    CLASSIC {
        @Override
        public void transfer(ITransferSource source, ITransferDestination destination, int value) {
            source.removeFunds(value);
            destination.addFunds(value);
        }
    };


}
