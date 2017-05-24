package org.david.algorithms.codewars;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * Created by David Marques on 21/05/2017.
 */
public class DirReductionTest {

    @Test
    public void testSimpleDirReduc() throws Exception {
        assertThat(DirReduction.dirReduc(new String[]{"NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST"})).isEqualTo(new String[]{"WEST"});
        assertThat(DirReduction.dirReduc(new String[]{"NORTH", "WEST", "SOUTH", "EAST"})).isEqualTo(new String[]{"NORTH", "WEST", "SOUTH", "EAST"});
    }

    @Test
    public void invalidArgs() throws Exception {
        assertThat(DirReduction.dirReduc(new String[]{})).isEqualTo(new String []{});
        assertThat(DirReduction.dirReduc(new String[]{""})).isEqualTo(new String []{""});
    }
}