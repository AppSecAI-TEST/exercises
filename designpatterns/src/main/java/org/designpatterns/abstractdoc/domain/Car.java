package org.designpatterns.abstractdoc.domain;

import org.designpatterns.abstractdoc.AbstractDocument;

import java.util.Map;

/**
 * Created by David Marques on 28/05/2017.
 */
public class Car extends AbstractDocument implements HasPrice, HasParts, HasModel {

    public Car(Map<String, Object> properties) {
        super(properties);
    }
}
