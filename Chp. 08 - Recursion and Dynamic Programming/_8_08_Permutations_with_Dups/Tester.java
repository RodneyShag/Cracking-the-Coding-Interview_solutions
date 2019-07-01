package _8_08_Permutations_with_Dups;

import java.util.*;

public class Tester {
    public static void main(String[] args) {
        System.out.println("*** Test 8.8: Permutations with Dups\n");
        test(new int[]{1,2,3});
        test(new int[]{1,1,4});
    }

    private static void test(int[] array) {
        List<List<Integer>> permutations = PermutationsWithDups.permute(array);
        System.out.println("Original array: " + Arrays.toString(array));
        System.out.println("Permutations: " + permutations + "\n");
    }
}
