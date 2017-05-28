package org.designpatterns.abstractdoc.domain;

import org.designpatterns.abstractdoc.Document;

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
