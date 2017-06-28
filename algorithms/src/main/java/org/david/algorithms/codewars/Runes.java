package org.david.algorithms.codewars;

/**
 * Created by David Marques on 08/06/2017.
 */
public class Runes {

    public static int solveExpression(final String expression) {
        String[] op = expression.split("=");
        if (op[0].contains("*")) {
            return sol('*', op[0].split("\\*"), op[1],expression);
        } else if (op[0].contains("+")) {
            return sol('+', op[0].split("\\+"), op[1],expression);
        } else {
            StringBuilder sc = new StringBuilder(op[0]);
            if(op[0].contains("--")) {
                sc = new StringBuilder(op[0].replaceAll("--","+"));
            return sol('+', sc.toString().split("\\+"), op[1],expression);
            }else {
                sc.setCharAt(op[0].lastIndexOf('-'), 'x');
            return sol('-', sc.toString().split("x"), op[1],expression);
            }
        }
    }

    public static int sol(char op, String[] elems, String result, String expression) {
        int r = -1;
        for (int i = 0; i < 10; i++) {
            if((result.length()>1 && result.startsWith("?") && i==0) ||expression.contains(""+i)) {
                continue;
            }
            int el1 = Integer.valueOf(elems[0].replaceAll("\\?", "" + i));
            int el2 = Integer.valueOf(elems[1].replaceAll("\\?", "" + i));
            int res = Integer.valueOf(result.replaceAll("\\?", "" + i));

            if ((op == '*' && (el1 * el2 == res))
                    || (op == '-' && (el1 - el2 == res))
                    || (op == '+' && (el1 + el2 == res))) {
                return i;
            }
        }
        return r;
    }
}
