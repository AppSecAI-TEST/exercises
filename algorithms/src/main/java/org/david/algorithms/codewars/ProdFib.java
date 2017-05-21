package org.david.algorithms.codewars;

/**
 * Created by David Marques on 21/05/2017.
 */
public class ProdFib {

    public static long[] productFib(long prod) {
        long fibA = 0;
        long fibB = 1;

        while (fibA * fibB < prod) {
            long aux = fibA;
            fibA = fibB;
            fibB = fibA + aux;
        }
        return new long[]{fibA, fibB, fibA * fibB == prod ? 1 : 0};
    }
}
