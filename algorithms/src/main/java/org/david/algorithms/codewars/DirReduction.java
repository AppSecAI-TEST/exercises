package org.david.algorithms.codewars;

import java.util.Stack;

/**
 * Created by David Marques on 21/05/2017.
 */
public class DirReduction {

    public static String[] dirReduc(String[] arr) {
        Stack<String> stack = new Stack<>();
        if (arr != null && arr.length > 0) {
            for (String dirc : arr) {
                if (stack.empty()) {
                    stack.push(dirc);
                } else {
                    if ("NORTH".equals(dirc) && "SOUTH".equals(stack.peek())) {
                        stack.pop();
                    } else if ("SOUTH".equals(dirc) && "NORTH".equals(stack.peek())) {
                        stack.pop();
                    } else if ("WEST".equals(dirc) && "EAST".equals(stack.peek())) {
                        stack.pop();
                    } else if ("EAST".equals(dirc) && "WEST".equals(stack.peek())) {
                        stack.pop();
                    } else if ("NORTHSOUTHEASTWEST".contains(dirc)) {
                        stack.push(dirc);
                    }
                }

            }
        }
        return stack.toArray(new String[0]);
    }
}
