package org.david.algorithms.codewars;


import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by David Marques on 21/05/2017.
 */
public class SumOfDividedTest {
    @Test
    public void testOne() {
        int[] lst = new int[]{12, 15};
        assertThat(SumOfDivided.sumOfDivided(lst)).isEqualTo("(2 12)(3 27)(5 15)");
    }

    @Test
    public void testPrimeNumberGenerator() throws Exception {
        assertThat(SumOfDivided.getPrimeList(11)).isEqualTo(Arrays.asList(2, 3, 5, 7, 11));
    }
}