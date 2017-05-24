package org.david.exercises.solid.d.sol;

/**
 * Created by David Marques on 24/05/2017.
 */
public interface ITransferStrategy {

    void transfer(ITransferSource source, ITransferDestination destination, int value);
}
