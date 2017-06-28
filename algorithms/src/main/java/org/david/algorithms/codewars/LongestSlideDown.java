package org.david.algorithms.codewars;

/**
 * Created by David Marques on 08/06/2017.
 */
public class LongestSlideDown {

    public static int longestSlideDown(int[][] pyramid) {
        int result = pyramid[0][0];
        int maxIdx = 0;
        for(int i=1; i < pyramid.length; i ++) {
            result += pyramid[i][maxIdx+1] > pyramid[i][maxIdx] ? pyramid[i][maxIdx+1]: pyramid[i][maxIdx];
            maxIdx = pyramid[i][maxIdx+1] > pyramid[i][maxIdx] ? maxIdx+1 : maxIdx;
        }
        return result;
    }
}
