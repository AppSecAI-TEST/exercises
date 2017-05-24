package org.david.exercises.solid.o.sol;

import java.io.PrintStream;

/**
 * Created by David Marques on 23/05/2017.
 */
public class ConsoleLogger implements IMessageLogger {

    private PrintStream printWriter;

    public ConsoleLogger(PrintStream printWriter) {
        this.printWriter = printWriter;
    }

    /**
     * By default we write to system.out
     */
    public ConsoleLogger() {
        printWriter = System.out;
    }

    @Override
    public void log(String message) throws LoggerException {
        printWriter.println(message);
    }

}
