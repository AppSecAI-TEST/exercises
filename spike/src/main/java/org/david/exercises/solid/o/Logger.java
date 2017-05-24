package org.david.exercises.solid.o;

import java.io.File;
import java.io.FileWriter;

/**
 * Created by David Marques on 23/05/2017.
 */
public class Logger {

    ///This class is not open to extension due the lack of explicit DI and it's depending on detail not abstractions.
    public void log(String message, LogType type) throws Exception {
        switch (type) {
            case Console:
                System.out.print(message);
                break;
            case File:
                //FileWriter fileWriter = new FileWriter(new File("temp"));
                //fileWriter.write(message);
                break;
        }
    }

    public enum LogType {
        Console,
        File;
    }
}
