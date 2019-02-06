package _10_01_Sorted_Merge;

import java.util.Arrays;

public class Tester {
    public static void main(String[] args) {
        System.out.println("*** 10.1: Sorted Merge");
        test(new int[]{ 3, 6, 8, 9, 0, 0, 0, 0 }, new int[]{ 1, 2, 4, 7 }, 3, 3);
    }

    private static void test(int[] arrayA, int[] arrayB, int lastA, int lastB) {
        System.out.println("Original arrays: " + Arrays.toString(arrayA) + " " + Arrays.toString(arrayB));
        SortedMerge.merge(arrayA, arrayB, lastA, lastB);
        System.out.println("Merged: " + Arrays.toString(arrayA));
    }
}
