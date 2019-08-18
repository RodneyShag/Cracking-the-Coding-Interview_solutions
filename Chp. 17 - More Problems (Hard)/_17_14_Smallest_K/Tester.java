package _17_14_Smallest_K;

import java.util.Arrays;

public class Tester {
    public static void main(String[] args) {
        System.out.println("*** Test 17.14: Smallest K\n");
        int[] array = { 52, 10, 39, 26, 42, 31, 26, 0, 6, 19, 61, 33, 14, 26, 22, 25 };
        System.out.println(Arrays.toString(array));
        test(array, 3);
        test(array, 9);
        test(array, 12);
    }

    private static void test(int[] array, int k) {
        System.out.format("\n%2d Smallest: ", k);
        SmallestK.findNthSmallestNums(array, k);
    }
}
