package _8_08_Permutations_with_Dups;

import java.util.ArrayList;

public class Tester {
    public static void main(String[] args) {
        System.out.println("*** Test 8.8: Permutations with Dups\n");
        test("cat");
        test("foo");
    }

    private static void test(String str) {
        ArrayList<String> permutations = PermutationsWithDups.getPermutations(str);
        System.out.println("Original string: " + str);
        System.out.println("Permutations: " + permutations + "\n");
    }
}
