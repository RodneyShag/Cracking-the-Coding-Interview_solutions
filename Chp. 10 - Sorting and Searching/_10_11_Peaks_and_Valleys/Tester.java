package _10_11_Peaks_and_Valleys;

import java.util.Arrays;

public class Tester {
    public static void main(String[] args) {
        System.out.println("*** 10.11: Peaks and Valleys");
        test(new int[]{ 5, 3, 1, 2, 3 });
        test(new int[]{ 1, 2, 3, 4, 5 });
    }

    private static void test(int[] array) {
        System.out.println("\nOriginal: " + Arrays.toString(array));
        PeaksAndValleys.sortValleyPeak(array);
        System.out.println("Altered:  " + Arrays.toString(array));

    }
}
