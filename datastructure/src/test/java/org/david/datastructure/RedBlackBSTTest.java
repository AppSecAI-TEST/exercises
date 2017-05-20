package org.david.datastructure;

import org.junit.Test;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by David Marques on 20/05/2017.
 */
public class RedBlackBSTTest {

    @Test
    public void testCreateEmptyBST() {
        RedBlackBST testSubject = new RedBlackBST();
        assertThat(testSubject.size()).isEqualTo(0);
    }

    @Test
    public void testNonEmptyBST() throws Exception {
        RedBlackBST<Integer, Integer> redBlackBST = new RedBlackBST<>();
        redBlackBST.put(10, 10);
        redBlackBST.put(15, 10);
        redBlackBST.put(16, 10);
        redBlackBST.put(17, 10);
        assertThat(redBlackBST.size()).isEqualTo(4);
    }

    @Test
    public void randomLoadTest() throws Exception {
        final RedBlackBST<Integer, Integer> redBlackBST = new RedBlackBST<Integer,Integer>();
        IntStream.range(1, 10001).forEach(i -> redBlackBST.put(i, i + 1));
        assertThat(redBlackBST.size()).isEqualTo(10000);
    }
}