// github.com/RodneyShag

package _8_09_Parens;

import java.util.*;

public class Parens {
    public static List<String> generateParentheses(int n) {
        List<String> solutions = new ArrayList();
        addParenthesis(new char[n * 2], 0, n, n, solutions);
        return solutions;
    }

    private static void addParenthesis(char[] expression, int index, int leftRem, int rightRem, List<String> solutions) {
        if (leftRem == 0 && rightRem == 0) {
            solutions.add(new String(expression));
            return;
        }
        if (leftRem > 0) {
            expression[index] = '(';
            addParenthesis(expression, index + 1, leftRem - 1, rightRem, solutions);
        }
        if (rightRem > 0 && rightRem > leftRem) {
            expression[index] = ')';
            addParenthesis(expression, index + 1, leftRem, rightRem - 1, solutions);
        }
    }
}
