package org.designpatterns.abstractdoc;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * Created by David Marques on 28/05/2017.
 */
public class AbstractDocument implements Document {

    private final Map<String, Object> properties;

    protected AbstractDocument(Map<String, Object> properties) {
        this.properties = properties;
    }

    @Override
    public final Object get(String key) {
        return properties.get(key);
    }

    @Override
    public final void put(String key, Object value) {
        properties.put(key, value);
    }

    @Override
    public final <T> Stream<T> children(String key, Function<Map<String, Object>, T> constructor) {
        Optional<List<Map<String, Object>>> any = Stream.of(get(key))
                .filter(el -> el != null)
                .map(o -> (List<Map<String, Object>>) o).findAny();
        return any.isPresent() ? any.get().stream().map(constructor) : Stream.empty();
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(" Properties [");
        properties.entrySet().forEach(e -> sb.append("[").append(e + ":").append(e.getValue()).append("]"));
        return sb.toString();
    }
}
