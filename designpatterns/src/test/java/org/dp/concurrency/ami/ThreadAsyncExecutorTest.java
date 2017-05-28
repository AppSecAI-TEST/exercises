package org.dp.concurrency.ami;

import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Matchers;

import java.util.Optional;
import java.util.concurrent.Callable;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;
import static org.mockito.Mockito.*;

/**
 * Created by David Marques on 28/05/2017.
 */
public class ThreadAsyncExecutorTest {

    @Test(timeout = 3000)
    public void testSuccessfulTaskWithoutCallback() throws Exception {
        final AsyncExecutor executor = new ThreadAsyncExecutor();

        final Object result = new Object();
        final Callable<Object> task = mock(Callable.class);
        when(task.call()).thenReturn(result);

        final AsyncResult asyncResult = executor.startProcess(task);
        assertThat(asyncResult).isNotNull();
        asyncResult.await();
        assertThat(asyncResult.isComplete()).isTrue();

        assertThat(asyncResult.getValue()).isSameAs(result);
    }

    @Test(timeout = 3000)
    public void testSuccessfulTaskWithCallback() throws Exception {
        final AsyncExecutor executor = new ThreadAsyncExecutor();
        final Object result = new Object();
        final Callable<Object> task = mock(Callable.class);
        when(task.call()).thenReturn(result);

        final AsyncCallback<Object> callback = mock(AsyncCallback.class);
        final AsyncResult asyncResult = executor.startProcess(task, callback);
        assertThat(asyncResult).isNotNull();
        asyncResult.await();
        assertThat(asyncResult.isComplete()).isTrue();

        verify(task, times(1)).call();

        final ArgumentCaptor<Optional<Exception>> captor = ArgumentCaptor.forClass((Class) Optional.class);
        verify(callback, times(1)).onComplete(eq(result), captor.capture());

        assertThat(captor.getValue()).isNotNull();
        assertThat(captor.getValue().isPresent()).isFalse();

        assertThat(asyncResult.getValue()).isSameAs(result);
    }

    @Test(timeout = 5000)
    public void testLongRunningTaskWithoutCallBack() throws Exception {
        final AsyncExecutor executor = new ThreadAsyncExecutor();
        final Object result = new Object();
        final Callable<Object> task = mock(Callable.class);

        when(task.call()).thenAnswer(i -> {
            Thread.sleep(1500);
            return result;
        });

        final AsyncResult asyncResult = executor.startProcess(task);

        assertThat(asyncResult).isNotNull();
        assertThat(asyncResult.isComplete()).isFalse();

        try {
            asyncResult.getValue();
            fail("Should throw an IllegalStateException ");
        } catch (IllegalStateException e) {
            assertThat(e.getMessage()).isNotEmpty();
        }

        verify(task, timeout(3000).times(1)).call();

        asyncResult.await();

        assertThat(asyncResult.isComplete()).isTrue();
        verifyNoMoreInteractions(task);
        assertThat(asyncResult.getValue()).isSameAs(result);

    }

    @Test(timeout = 5000)
    public void testLongRunningTaskWithCallback() throws Exception {
        final AsyncExecutor executor = new ThreadAsyncExecutor();
        final Object result = new Object();
        final Callable<Object> task = mock(Callable.class);

        when(task.call()).thenAnswer(i -> {
            Thread.sleep(1500);
            return result;
        });

        final AsyncCallback callback = mock(AsyncCallback.class);
        final AsyncResult asyncResult = executor.startProcess(task, callback);

        assertThat(asyncResult).isNotNull();
        assertThat(asyncResult.isComplete()).isFalse();

        verifyZeroInteractions(callback);

        try {
            asyncResult.getValue();
            fail("Should throw an IllegalStateException ");
        } catch (IllegalStateException e) {
            assertThat(e.getMessage()).isNotEmpty();
        }

        verify(task, timeout(3000).times(1)).call();
        ArgumentCaptor<Optional<Exception>> captor = ArgumentCaptor.forClass((Class) Optional.class);
        verify(callback, timeout(3000).times(1)).onComplete(eq(result), captor.capture());
        assertThat(captor.getValue().isPresent()).isFalse();

        asyncResult.await();

        assertThat(asyncResult.isComplete()).isTrue();
        verifyNoMoreInteractions(task, callback);
        assertThat(asyncResult.getValue()).isSameAs(result);

    }


    @Test(timeout = 5000)
    public void testEndProcess() throws Exception {
        final AsyncExecutor executor = new ThreadAsyncExecutor();
        final Object result = new Object();
        final Callable<Object> task = mock(Callable.class);

        when(task.call()).thenAnswer(i -> {
            Thread.sleep(1500);
            return result;
        });

        final AsyncResult asyncResult = executor.startProcess(task);

        assertThat(asyncResult).isNotNull();
        assertThat(asyncResult.isComplete()).isFalse();

        try {
            asyncResult.getValue();
            fail("Should throw an IllegalStateException ");
        } catch (IllegalStateException e) {
            assertThat(e.getMessage()).isNotEmpty();
        }

        assertThat(executor.endProcess(asyncResult)).isSameAs(result);
        verify(task, times(1)).call();


        assertThat(asyncResult.isComplete()).isTrue();
        verifyNoMoreInteractions(task);
        assertThat(executor.endProcess(asyncResult)).isSameAs(result);

    }

    @Test(timeout = 3000)
    public void testNullTask() throws Exception {
        final AsyncExecutor executor = new ThreadAsyncExecutor();
        final AsyncResult asyncResult = executor.startProcess(null);

        assertThat(asyncResult).isNotNull().describedAs(AsyncResult.class.getName() + " should not be null");
        asyncResult.await();
        assertThat(asyncResult.isComplete()).isTrue();

        try {
            asyncResult.getValue();
            fail("should throw an NPE at this point");
        } catch (Exception e) {
            assertThat(e.getCause()).isInstanceOf(NullPointerException.class);
        }
    }

    @Test(timeout = 4000)
    public void testNullTaskWithCallback() throws Exception {
        final AsyncExecutor executor = new ThreadAsyncExecutor();
        final AsyncCallback callback = mock(AsyncCallback.class);
        final AsyncResult asyncResult = executor.startProcess(null, callback);

        assertThat(asyncResult).isNotNull().describedAs(AsyncResult.class.getName() + " should not be null");
        asyncResult.await();
        assertThat(asyncResult.isComplete()).isTrue();

        ArgumentCaptor<Optional<Exception>> captor = ArgumentCaptor.forClass((Class) Optional.class);
        verify(callback, times(1)).onComplete(Matchers.isNull(), captor.capture());

        assertThat(captor.getValue().isPresent()).isTrue();
        assertThat(captor.getValue().get()).isInstanceOf(NullPointerException.class);

        try {
            asyncResult.getValue();
            fail("should throw an NPE at this point");
        } catch (Exception e) {
            assertThat(e.getCause()).isInstanceOf(NullPointerException.class);
        }
    }


}