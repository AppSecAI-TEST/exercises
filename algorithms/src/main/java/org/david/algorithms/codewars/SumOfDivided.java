package org.david.algorithms.codewars;

/**
 * Created by David Marques on 21/05/2017.
 */

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.sort;

/**
 * Given an array of positive or negative integers
 * <p>
 * I= [i1,..,in]
 * <p>
 * you have to produce a sorted array P of the form
 * <p>
 * [ [p, sum of all ij of I for which p is a prime factor (p positive) of ij] ...]
 * <p>
 * P will be sorted by increasing order of the prime numbers. The final result has to be given as a string in Java, C# or
 * C++ and as an array of arrays in other languages.
 * <p>
 * Example:
 * <p>
 * I = {12, 15}; // result = "(2 12)(3 27)(5 15)"
 * [2, 3, 5] is the list of all prime factors of the elements of I, hence the result.
 * <p>
 * Notes: It can happen that a sum is 0 if some numbers are negative!
 * <p>
 * Example: I = [15, 30, -45] 5 divides 15, 30 and (-45) so 5 appears in the result, the sum of the numbers for which 5
 * is a factor is 0 so we have [5, 0] in the result amongst others.
 */
public class SumOfDivided {

    public static String sumOfDivided(int[] l) {
        String result = "";
        sort(l);
        int maxAbs = Math.max(Math.abs(l[0]), Math.abs(l[l.length - 1]));
        List<Integer> primes = getPrimeList(maxAbs);
        for (Integer prime : primes) {
            int sum = 0;
            for (int el : l) {
                if (el % prime == 0)
                    sum += el;
            }
            if (sum > 0)
                result += "(" + prime + " " + sum + ")";
        }

        return result;
    }

    protected static List<Integer> getPrimeList(int n) {
        List<Integer> result = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) result.add(i);
        }
        return result;

    }

    private static boolean isPrime(int n) {
        if (n < 2 || (n != 2 && n % 2 == 0)) return false;
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }


}
