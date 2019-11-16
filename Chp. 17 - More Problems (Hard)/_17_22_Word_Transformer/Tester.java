// github.com/RodneyShag

package _17_22_Word_Transformer;

import java.util.ArrayDeque;

public class Tester {
    public static void main(String[] args) {
        System.out.println("*** Test 17.22: Word Transformer\n");
        WordTransformer.setUpDict();
        test("Damp", "Like");
    }

    private static void test(String s1, String s2) {
        ArrayDeque<String> solution = WordTransformer.convert(s1, s2);
        System.out.println(solution);
    }
}
