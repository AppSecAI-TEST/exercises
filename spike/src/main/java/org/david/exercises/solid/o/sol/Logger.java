package org.david.exercises.solid.o.sol;

/**
 * Created by David Marques on 23/05/2017.
 */
public class Logger {

    private IMessageLogger messageLogger;

    public Logger(IMessageLogger messageLogger) {
        this.messageLogger = messageLogger;
    }

    public void log(String message) throws Exception {
        messageLogger.log(message);
    }
}
