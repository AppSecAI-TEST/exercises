package org.david.algorithms.codewars;
/**
 * Created by David Marques on 21/05/2017.
 */

/**
 * The input is a string str of digits. Cut the string into chunks (a chunk here is a substring of the initial string) of size sz (ignore the last chunk if its size is less than sz).
 * <p>
 * If a chunk represents an integer such as the sum of the cubes of its digits is divisible by 2, reverse that chunk; otherwise rotate it to the left by one position. Put together these modified chunks and return the result as a string.
 * <p>
 * If
 * sz is <= 0 or if str is empty return ""
 * sz is greater (>) than the length of str it is impossible to take a chunk of size sz hence return "".
 * <p>
 * Examples:
 * revrot("123456987654", 6) --> "234561876549"
 * revrot("123456987653", 6) --> "234561356789"
 * revrot("66443875", 4) --> "44668753"
 * revrot("66443875", 8) --> "64438756"
 * revrot("664438769", 8) --> "67834466"
 * revrot("123456779", 8) --> "23456771"
 * revrot("", 8) --> ""
 * revrot("123456779", 0) --> ""
 * revrot("563000655734469485", 4) --> "0365065073456944"
 */
public class RevRot {
    public static String revRot(String strng, int sz) {
        if (sz <= 0 || strng == null || strng.equals("")) {
            return "";
        }
        int numOfChunks = strng.length() / sz;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < numOfChunks; i++) {
            int start = i * sz;
            int end = (i + 1) * sz;
            String chunk = strng.substring(start, end);
            if (isPerfectCube(chunk)) {
                sb.append(new StringBuffer(chunk).reverse().toString());
            } else {
                char first = chunk.charAt(0);
                StringBuffer strB = new StringBuffer(chunk).deleteCharAt(0).append(first);
                sb.append(strB.toString());
            }
        }
        return sb.toString();
    }

    private static boolean isPerfectCube(String substring) {
        int sum = 0;
        for (char c : substring.toCharArray()) {
            sum += c*c*c;
        }
        return sum % 2 == 0;
    }
}
