package org.david.exercises.solid.o.sol;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
 * Created by David Marques on 23/05/2017.
 */
public class FileLogger implements IMessageLogger {

    private File file;

    public FileLogger(File file) {
        this.file = file;
    }

    @Override
    public void log(String message) throws LoggerException {
        try {
            Files.write(file.toPath(), message.getBytes());
        } catch (IOException e) {
            throw new LoggerException(e);
        }
    }
}
