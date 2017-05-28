package org.designpatterns.abstractdoc;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * Created by David Marques on 28/05/2017.

 https://en.wikipedia.org/wiki/Abstract_Document_Pattern

 When to use this pattern :
 -1- there is a need to add new properties on the fly
 -2- you want a flexible way to organize domain in tree like structure
 -3- you want more loosely coupled system
 This is a great pattern for message driven systems.
 */
public interface Document {

    Object get(String key);

    void put(String key, Object value);

    <T> Stream<T> children(String key, Function<Map<String, Object>, T> constructor);
}
