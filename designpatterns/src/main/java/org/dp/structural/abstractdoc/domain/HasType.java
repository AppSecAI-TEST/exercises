package org.dp.structural.abstractdoc.domain;

import org.dp.structural.abstractdoc.Document;

import java.util.Optional;

/**
 * Created by David Marques on 28/05/2017.
 */
public interface HasType extends Document {
    String PROPERTY_KEY = "type";

    default Optional<String> getType() {
        return Optional.ofNullable((String) get(PROPERTY_KEY));
    }
}
