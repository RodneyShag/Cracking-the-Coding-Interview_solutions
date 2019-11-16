// github.com/RodneyShag

package __Intro_Binary_Search;

import java.util.Arrays;

public class Tester {
    public static void main(String[] args) {
        System.out.println("*** Test Binary Search");
        test(new int[]{ -3, -1, 0, 2, 9, 22, 23, 25, 53 }, -1);
        test(new int[]{ -5, -4, 0, 1, 2 }, 2);

    }

    private static void test(int[] sortedArray, int value) {
        System.out.println("\nOriginal array: " + Arrays.toString(sortedArray));
        System.out.println(value + " is at index " + BinarySearch.Iterative(sortedArray, value));
        System.out.println(value + " is at index " + BinarySearch.Recursive(sortedArray, value));
    }
}
