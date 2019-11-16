// github.com/RodneyShag

package _8_09_Parens;

import java.util.*;

public class Tester {
    public static void main(String[] args) {
        System.out.println("*** Test 8.9: Parens\n");
        test(2);
        test(3);
    }

    private static void test(int n) {
        System.out.println("n = " + n);
        List<String> list = Parens.generateParentheses(n);
        for (String str : list) {
            System.out.println(str);
        }
        System.out.println("Number of solutions: " + list.size() + "\n");
    }
}
