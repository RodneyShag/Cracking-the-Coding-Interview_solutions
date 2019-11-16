// github.com/RodneyShag

package _1_2_Check_Permutations;

public class Tester {
    public static void main(String[] args) {
        System.out.println("*** Test 1.2: Check Permutations\n");
        test("hello", "olhel");
        test("james", "bean");
    }

    private static void test(String s1, String s2) {
        System.out.format("%s, %s: %s\n", s1, s2, CheckPermutations.isPermutation(s1, s2));
    }
}
