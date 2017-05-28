package org.dp.structural.abstractdoc.domain;

import org.dp.structural.abstractdoc.AbstractDocument;

import java.util.Map;

/**
 * Created by David Marques on 28/05/2017.
 */
public class Part extends AbstractDocument implements HasType, HasModel, HasPrice {

    public Part(Map<String, Object> properties) {
        super(properties);
    }
}
