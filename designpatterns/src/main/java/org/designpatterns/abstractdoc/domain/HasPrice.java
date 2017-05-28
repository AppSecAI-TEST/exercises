package org.designpatterns.abstractdoc.domain;

import org.designpatterns.abstractdoc.Document;

import java.util.Optional;

/**
 * Created by David Marques on 28/05/2017.
 */
public interface HasPrice extends Document {

    String PROPERTY_KEY = "price";

    default Optional<Number> getPrice() {
        return Optional.ofNullable((Number) get(PROPERTY_KEY));
    }
}
