package org.dp.concurrency.ami;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

/**
 * Created by David Marques on 28/05/2017.
 * https://en.wikipedia.org/wiki/Asynchronous_method_invocation
 * This pattern can be used:
 * -1- When we have multiple tasks that can run in parallel
 * -2- need to improve the performance of a group of sequential tasks
 * -3- Limited runtime time resources so caller shouldn't be blocked waiting for task to be completed (delegates that to the callback)
 */
public interface AsyncExecutor {

    <T> AsyncResult startProcess(Callable<T> task);

    <T> AsyncResult startProcess(Callable<T> task, AsyncCallback<T> callback);

    <T> T endProcess(AsyncResult<T> result) throws ExecutionException, InterruptedException;
}
