package org.david.algorithms.codewars;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by David Marques on 08/06/2017.
 */
public class RunesTest {
    @Test
    public void testSplit() throws Exception {
        String op = "19--45=5?";
        String[] split = op.split("=");
        System.out.println(split[0]);
        System.out.println(split[1]);
    }

    @Test
    public void testSample() {
        assertEquals( "Answer for expression '1+1=?' " , 2 , Runes.solveExpression("1+1=?") );
        assertEquals( "Answer for expression '123*45?=5?088' " , 6 , Runes.solveExpression("123*45?=5?088") );
        assertEquals( "Answer for expression '-5?*-1=5?' " , 0 , Runes.solveExpression("-5?*-1=5?") );
        assertEquals( "Answer for expression '19--45=5?' " , -1 , Runes.solveExpression("19--45=5?") );
        assertEquals( "Answer for expression '??*??=302?' " , 5 , Runes.solveExpression("??*??=302?") );
        assertEquals( "Answer for expression '?*11=??' " , 2 , Runes.solveExpression("?*11=??") );
        assertEquals( "Answer for expression '-7715?5--484?00=-28?9?5' " , 6 , Runes.solveExpression("-7715?5--484?00=-28?9?5") );
    }

}