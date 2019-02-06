package _17_16_The_Masseuse;

import java.util.Arrays;

public class Tester {
    public static void main(String[] args) {
        System.out.println("*** Test 17.16: The Masseuse\n");
        test(new int[]{ 30, 15, 60, 75, 45, 15, 15, 45 });
    }

    private static void test(int[] array) {
        System.out.println(Arrays.toString(array));
        System.out.println("Solution 1: " + TheMasseuse.maxMinutes1(array));
        System.out.println("Solution 2: " + TheMasseuse.maxMinutes2(array));
    }
}
