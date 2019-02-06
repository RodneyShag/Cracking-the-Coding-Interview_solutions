package _16_21_Sum_Swap;

import java.util.Arrays;

public class Tester {
    public static void main(String[] args) {
        System.out.println("*** Test 16.21: Sum Swap\n");
        test(new int[]{ 4, 1, 2, 1, 1, 2 }, new int[]{ 3, 6, 3, 3 });
    }

    private static void test(int[] arrayA, int[] arrayB) {
        System.out.println("arrayA: " + Arrays.toString(arrayA));
        System.out.println("arrayB: " + Arrays.toString(arrayB));
        SumSwap.toSwap(arrayA, arrayB);
    }
}
