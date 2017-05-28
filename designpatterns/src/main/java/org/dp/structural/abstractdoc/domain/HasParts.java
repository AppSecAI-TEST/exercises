package org.dp.structural.abstractdoc.domain;

import org.dp.structural.abstractdoc.Document;

import java.util.stream.Stream;

/**
 * Created by David Marques on 28/05/2017.
 */
public interface HasParts extends Document {
    String PROPERTY_KEY = "parts";

    default Stream<Part> getParts() {
        return children(PROPERTY_KEY, Part::new);
    }
}
