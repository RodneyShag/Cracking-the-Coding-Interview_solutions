package _17_21_Volume_of_Histogram;

import java.util.Arrays;

public class Tester {
    public static void main(String[] args) {
        System.out.println("*** Test 17.21: Volume of Histogram\n");
        int[] histogram = { 0, 0, 4, 0, 0, 6, 0, 0, 3, 0, 5, 0, 1, 0, 0, 0 };
        test(histogram);
    }

    private static void test(int[] histogram) {
        System.out.println(Arrays.toString(histogram));
        int result = VolumeOfHistogram.computeHistogramVolume(histogram);
        System.out.println("volume of histogram = " + result);
    }
}
