package org.david.threads.examples;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by David Marques on 14/06/2017.
 */
public class ThreadExamples {

    private static final Logger logger = LoggerFactory.getLogger(ThreadExamples.class);

    public void doThreadExercise1() {
        logger.info("Start");
        Runnable task = () -> {
            String threadName = Thread.currentThread().getName();
            logger.info("Hello I'm thread {}", threadName);
        };

        task.run();

        Thread myThread = new Thread(task);
        myThread.start();

        logger.info("Done");
    }
}
