package org.david.exercises.solid.o.sol;

/**
 * Created by David Marques on 24/05/2017.
 */
public class LoggerException extends Exception {

    public LoggerException(Throwable cause) {
        super("Exception happened: ", cause);
    }
}
