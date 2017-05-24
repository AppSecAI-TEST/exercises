package org.david.exercises.solid.o.sol;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.nio.file.Files;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by David Marques on 24/05/2017.
 */
public class FileLoggerTest {

    private File file;

    @Before
    public void setUp() throws Exception {
        file = new File("fileLogger.log");
    }

    @After
    public void tearDown() throws Exception {
        Files.delete(file.toPath());
    }

    @Test
    public void testLogToAFile() throws Exception {
        FileLogger fileLogger = new FileLogger(file);
        String message = "Hello World";
        fileLogger.log(message);
        List<String> lines = Files.readAllLines(file.toPath());
        assertThat(lines).containsExactly(message);
    }
}