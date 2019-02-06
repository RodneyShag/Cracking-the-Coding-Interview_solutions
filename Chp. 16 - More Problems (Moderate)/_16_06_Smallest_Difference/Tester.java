package _16_06_Smallest_Difference;

import java.util.Arrays;

public class Tester {
    public static void main(String[] args) {
        System.out.println("*** Test 16.6: Smallest Difference");
        test(new int[]{ 1, 3, 15, 11, 2 }, new int[]{ 23, 127, 235, 19, 8 });
    }

    private static void test(int[] array1, int[] array2) {
        System.out.println("\nArray 1: " + Arrays.toString(array1));
        System.out.println("Array 2: " + Arrays.toString(array2));
        int difference = SmallestDifference.smallestDifference(array1, array2);
        System.out.println("Smallest difference = " + difference);
    }
}
