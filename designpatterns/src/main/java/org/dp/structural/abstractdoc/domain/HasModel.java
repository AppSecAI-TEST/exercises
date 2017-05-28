package org.dp.structural.abstractdoc.domain;

import org.dp.structural.abstractdoc.Document;

import java.util.Optional;


/**
 * Created by David Marques on 28/05/2017.
 */
public interface HasModel extends Document {
    String PROPERTY_KEY = "model";

    default Optional<String> getModel() {
        return Optional.ofNullable((String) get(PROPERTY_KEY));
    }
}
