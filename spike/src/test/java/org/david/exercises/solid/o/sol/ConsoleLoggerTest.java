package org.david.exercises.solid.o.sol;

import org.junit.Before;
import org.junit.Test;
import org.mockito.*;

import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by David Marques on 24/05/2017.
 */
public class ConsoleLoggerTest {

    @Mock
    private PrintStream printStream;

    @Captor
    private ArgumentCaptor<String> captor;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testConsoleLogging() throws Exception {
        ConsoleLogger consoleLogger = new ConsoleLogger(printStream);
        String message = "Hello World";
        consoleLogger.log(message);
        Mockito.verify(printStream).println(captor.capture());
        assertThat(captor.getValue()).isEqualTo(message);
    }
}