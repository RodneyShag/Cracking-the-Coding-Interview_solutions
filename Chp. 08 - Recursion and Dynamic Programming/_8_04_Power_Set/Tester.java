package _8_04_Power_Set;

import java.util.*;

public class Tester {
    public static void main(String[] args) {
        System.out.println("*** Test 8.4: Power Set\n");
        int[] array = new int[]{3,5,3};
        test(array);
    }

    private static void test(int[] array) {
        List<List<Integer>> subsets = PowerSet.getSubsets(array);
        System.out.println("Original array: " + Arrays.toString(array));
        System.out.println("Subsets: " + subsets + "\n");
    }
}
