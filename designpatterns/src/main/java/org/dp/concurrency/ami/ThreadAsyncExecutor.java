package org.dp.concurrency.ami;

import java.util.Optional;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;


/**
 * Created by David Marques on 28/05/2017.
 */
public class ThreadAsyncExecutor implements AsyncExecutor {

    private AtomicInteger index = new AtomicInteger(0);

    @Override
    public <T> AsyncResult startProcess(Callable<T> task) {
        return startProcess(task, null);
    }

    @Override
    public <T> AsyncResult startProcess(Callable<T> task, AsyncCallback<T> callback) {
        CompletableResult result = new CompletableResult(callback);
        new Thread(() -> {
            try {
                result.setValue(task.call());
            } catch (Exception e) {
                result.setException(e);
            }
        }, "ThreadAsyncExecutor" + index.incrementAndGet()).start();
        return result;
    }

    @Override
    public <T> T endProcess(AsyncResult<T> result) throws ExecutionException, InterruptedException {
        if (!result.isComplete()) {
            result.await();
        }
        return result.getValue();
    }

    private static class CompletableResult<T> implements AsyncResult<T> {

        //volatile to skip internal cache
        private volatile State state = State.RUNNING;


        private final Optional<AsyncCallback<T>> callback;
        private final Object lock;
        private T value;
        private Exception exception;

        private CompletableResult(AsyncCallback<T> callback) {
            this.callback = Optional.ofNullable(callback);
            this.lock = new Object();
        }

        void setValue(T value) {
            this.value = value;
            this.state = State.COMPLETED;
            this.callback.ifPresent(ac -> ac.onComplete(value, Optional.<Exception>empty()));
            synchronized (lock) {
                lock.notifyAll();
            }
        }

        void setException(Exception e) {
            this.exception = e;
            this.state = State.FAILED;
            this.callback.ifPresent(ac -> ac.onComplete(null, Optional.of(e)));
            synchronized (lock) {
                lock.notifyAll();
            }
        }

        @Override
        public boolean isComplete() {
            return state != State.RUNNING;
        }

        @Override
        public T getValue() throws ExecutionException {
            return (T) this.state.getValue(value, exception);
        }

        @Override
        public void await() throws InterruptedException {
            synchronized (lock) {
                if (!isComplete()) {
                    lock.wait();
                }
            }
        }

        enum State implements Value { //state+strategy pattern
            RUNNING {
                @Override
                public Object getValue(Object value, Exception e) throws ExecutionException {
                    throw new IllegalStateException("Execution not completed yet");
                }
            },
            FAILED {
                @Override
                public Object getValue(Object value, Exception e) throws ExecutionException {
                    throw new ExecutionException(e);
                }
            },
            COMPLETED
        }

        interface Value<T> {
            default T getValue(T value, Exception e) throws ExecutionException {
                return value;
            }
        }

    }
}
