package org.david.algorithms.playground;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by David Marques on 22/05/2017.
 * P(n,r) = n x (n-1) x (n-2) ... (n-k+1)
 */
public class Permutation {

    public static List<String> getPermutations(String string) {
        List<String> result = new ArrayList<>();
        if (string.length() == 0)
            return result;
        char[] chars = string.toCharArray();
        result.add("" + chars[0]);
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            int c_size = result.size();
            for (int j = c_size - 1; j > 0; i--) {
                String s = result.remove(i);
                for (int l = 0; l <= s.length(); l++) {
                    result.add(s.substring(0, l) + c + s.substring(l));
                }
            }
        }
        return result;
    }
}
