package org.designpatterns.abstractdoc.domain;

import org.designpatterns.abstractdoc.AbstractDocument;

import java.util.Map;

/**
 * Created by David Marques on 28/05/2017.
 */
public class Part extends AbstractDocument implements HasType, HasModel, HasPrice {

    public Part(Map<String, Object> properties) {
        super(properties);
    }
}
