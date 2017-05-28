package org.dp.concurrency.ami;

import java.util.concurrent.ExecutionException;

/**
 * Created by David Marques on 28/05/2017.
 */
public interface AsyncResult<T> {

    /**
     * Asynchronous task state
     *
     * @return <code>true</code> if execution is completed or fail
     */
    boolean isComplete();

    /**
     * @return return the value of the completed async task
     * @throws IllegalStateException if the async task is not completed
     * @throws ExecutionException    if the async task execution filed
     */
    T getValue() throws ExecutionException;

    void await() throws InterruptedException;
}
