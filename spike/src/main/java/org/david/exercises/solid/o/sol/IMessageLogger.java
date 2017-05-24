package org.david.exercises.solid.o.sol;

import javax.annotation.Nonnull;

/**
 * Created by David Marques on 23/05/2017.
 */
public interface IMessageLogger {

    void log(@Nonnull String message) throws LoggerException;

}
