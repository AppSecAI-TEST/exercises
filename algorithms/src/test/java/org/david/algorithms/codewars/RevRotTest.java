package org.david.algorithms.codewars;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;


/**
 * Created by David Marques on 21/05/2017.
 */
public class RevRotTest {
    private static void testing(String actual, String expected) {
        assertEquals(expected, actual);
    }

    @Test
    public void testMixFromCodeWars() {
        System.out.println("Fixed Tests: revRot");
        testing(RevRot.revRot("1234", 0), "");
        testing(RevRot.revRot("", 0), "");
        testing(RevRot.revRot("1234", 5), "");
        String s = "733049910872815764";
        testing(RevRot.revRot(s, 5), "330479108928157");
    }

    @Test
    public void testNonPerfectCubeSingleChunk() throws Exception {
        assertThat(RevRot.revRot("66443875", 8)).isEqualTo("64438756");
    }

    @Test
    public void testPerfectCubeSingleChunk() throws Exception {
        assertThat(RevRot.revRot("664438769", 8)).isEqualTo("67834466");
    }

    @Test
    public void testMixChunks() throws Exception {
        assertThat(RevRot.revRot("123456987653", 6)).isEqualTo("234561356789");
        assertThat(RevRot.revRot("66443875", 4)).isEqualTo("44668753");
        assertThat(RevRot.revRot("123456987654", 6)).isEqualTo("234561876549");
        assertThat(RevRot.revRot("66443875", 8)).isEqualTo("64438756");
        assertThat(RevRot.revRot("664438769", 8)).isEqualTo("67834466");
        assertThat(RevRot.revRot("123456779", 8)).isEqualTo("23456771");
        assertThat(RevRot.revRot("", 8)).isEqualTo("");
        assertThat(RevRot.revRot("123456779", 0)).isEqualTo("");
        assertThat(RevRot.revRot("563000655734469485", 4)).isEqualTo("0365065073456944");
    }
}