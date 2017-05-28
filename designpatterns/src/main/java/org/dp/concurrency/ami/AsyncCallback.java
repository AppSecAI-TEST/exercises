package org.dp.concurrency.ami;

import java.util.Optional;

/**
 * Created by David Marques on 28/05/2017.
 */
public interface AsyncCallback<T> {

    /**
     * Handler that is executed when the async task  is completed or fails
     * @param value the evaluated value from the async task
     * @param e is Empty if value execution succeeds or Exception if execution fails
     */
    void onComplete(T value, Optional<Exception> e);
}
