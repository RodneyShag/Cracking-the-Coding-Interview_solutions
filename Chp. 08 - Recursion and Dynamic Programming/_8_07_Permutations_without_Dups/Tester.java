// github.com/RodneyShag

package _8_07_Permutations_without_Dups;

import java.util.*;

public class Tester {
    public static void main(String[] args) {
        System.out.println("*** Test 8.7: Permutations without Dups\n");
        test(new int[]{1,2,3});
    }

    private static void test(int[] array) {
        List<List<Integer>> permutations = PermutationsWithoutDups.permute(array);
        System.out.println("Original array: " + Arrays.toString(array));
        System.out.println("Permutations: " + permutations + "\n");
    }
}
