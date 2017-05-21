package org.david.algorithms.codewars;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * Created by David Marques on 21/05/2017.
 */
public class ProdFibTest {
    @Test
    public void test1() {
        long[] r = new long[]{55, 89, 1};
        assertThat(ProdFib.productFib(4895)).isEqualTo(r);
    }

    @Test
    public void test2() {
        long[] r = new long[]{89, 144, 0};
        assertThat(ProdFib.productFib(5895)).isEqualTo(r);
    }
}