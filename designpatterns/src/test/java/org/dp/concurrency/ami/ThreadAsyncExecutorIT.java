package org.dp.concurrency.ami;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Callable;

/**
 * Created by David Marques on 28/05/2017.
 */
public class ThreadAsyncExecutorIT {

    private static final Logger logger = LoggerFactory.getLogger(ThreadAsyncExecutorIT.class);

    @Test
    public void testMultiTaskExecutionIntegrationTest() throws Exception {
        AsyncExecutor executor = new ThreadAsyncExecutor();

        AsyncResult<Integer> asyncResult = executor.startProcess(lazyTask(10, 500));
        AsyncResult<String> asyncResult1 = executor.startProcess(lazyTask("test", 300), callback("test"));
        AsyncResult<Long> asyncResult2 = executor.startProcess(lazyTask(50L, 700), callback(50L));
        AsyncResult<Integer> asyncResult3 = executor.startProcess(lazyTask(20, 400), callback(20));
        AsyncResult<String> asyncResult4 = executor.startProcess(lazyTask("Callback", 600), callback("Callback"));

        Thread.sleep(350);

        Integer result = executor.endProcess(asyncResult);
        String result1 = executor.endProcess(asyncResult1);
        Long result2 = executor.endProcess(asyncResult2);
        asyncResult3.await();
        asyncResult4.await();

        logger.info("Result "+result);
        logger.info("Result1 "+result1);
        logger.info("Result2 "+result2);
    }

    private <T> AsyncCallback<T> callback(T input) {
        String prefix = "callback result ";
        return (v, e) -> {
            e.ifPresent(
                    ex -> {
                        logger.info(prefix + input + "failed: "
                                + e.map(Exception::getMessage).
                                orElse(""));
                    });
            if (!e.isPresent()) {
                logger.info(prefix + input + ":" + v);
            }
        };
    }

    private <T> Callable<T> lazyTask(T value, int delayInMills) {
        return () -> {
            Thread.sleep(delayInMills);
            logger.info("Task completed for value :" + value);
            return value;
        };
    }


}