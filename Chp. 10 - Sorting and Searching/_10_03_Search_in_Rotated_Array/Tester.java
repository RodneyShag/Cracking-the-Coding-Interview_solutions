package _10_03_Search_in_Rotated_Array;

import java.util.Arrays;

public class Tester {
    public static void main(String[] args) {
        System.out.println("*** 10.3: Search in Rotated Array");
        int[] rotatedArray = { 15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14 };
        System.out.println("Rotated Array: " + Arrays.toString(rotatedArray));
        for (int num : rotatedArray) {
            test(rotatedArray, num);
        }
    }

    private static void test(int[] rotatedArray, int num) {
        System.out.format("%n%2d is at index: %2d", num, SearchInRotatedArray.search(rotatedArray, num));
    }
}
