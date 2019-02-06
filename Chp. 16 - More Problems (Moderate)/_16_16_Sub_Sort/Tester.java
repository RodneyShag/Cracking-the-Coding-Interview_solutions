package _16_16_Sub_Sort;

import java.util.Arrays;

public class Tester {
    public static void main(String[] args) {
        System.out.println("*** Test 16.16: Sub Sort");
        test(new int[]{ 1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19 });
        test(new int[]{ 1, 2, 4, 7, 10, 11, 12, 13, 16, 16, 18, 19 });
        test(new int[]{ 4, 6, 5, 2, 9, 8, 7, 10 });
    }

    private static void test(int[] array) {
        System.out.println("\nOriginal array: " + Arrays.toString(array));
        SubSort.minMax(array);
    }
}
