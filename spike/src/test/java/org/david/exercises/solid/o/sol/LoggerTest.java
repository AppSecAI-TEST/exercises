package org.david.exercises.solid.o.sol;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.File;
import java.io.PrintStream;
import java.nio.file.Files;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by David Marques on 24/05/2017.
 */
public class LoggerTest {

    private PrintStream printStream;

    @Before
    public void setUp() throws Exception {
        printStream = Mockito.spy(System.out);
    }

    @Test
    public void testIntegrationConsoleLogger() throws Exception {
        Logger logger = new Logger(new ConsoleLogger(printStream));
        String message = "Hello";
        logger.log(message);
        Mockito.verify(printStream).println(message);
    }

    @Test
    public void testIntegrationFileLogger() throws Exception {
        File file = new File("mySecondTest.log");
        Logger logger = new Logger(new FileLogger(file));
        String message = "Hello";
        logger.log(message);
        assertThat(file).hasContent(message);
        Files.delete(file.toPath());
    }
}