package org.designpatterns.abstractdoc;


import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by David Marques on 28/05/2017.
 */
public class AbstractDocumentTest {

    private class DocumentImpl extends AbstractDocument {
        protected DocumentImpl(Map<String, Object> properties) {
            super(properties);
        }
    }

    private AbstractDocument document;
    private static final String KEY = "key";
    private static final String Value = "Value";

    @Before
    public void setUp() throws Exception {
        document = new DocumentImpl(new HashMap<>());
    }

    @Test
    public void shouldPutAndGetValue() throws Exception {
        document.put(KEY, Value);
        assertThat(document.get(KEY)).isEqualTo(Value);
    }

    @Test
    public void shouldRetrieveChildren() throws Exception {
        Map<String, Object> child1 = new HashMap<>();
        Map<String, Object> child2 = new HashMap<>();
        List<Map<String, Object>> children = Arrays.asList(child1, child2);
        document.put(KEY, children);
        Stream<DocumentImpl> result = document.children(KEY, DocumentImpl::new);
        assertThat(result).isNotNull();
        assertThat(result.count()).isEqualTo(children.size());
    }

    @Test
    public void shouldRetrieveEmptyStreamForNonExistentChildren() throws Exception {
        Stream<DocumentImpl> children = document.children(KEY, DocumentImpl::new);
        assertThat(children).isNotNull();
        assertThat(children.count()).isEqualTo(0);
    }

}