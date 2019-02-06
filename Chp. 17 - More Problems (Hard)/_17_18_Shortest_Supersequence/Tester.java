package _17_18_Shortest_Supersequence;

import java.util.Arrays;

public class Tester {
    public static void main(String[] args) {
        System.out.println("*** Test 17.18: Shortest Supersequence \n");
        int[] arrayA = new int[]{ 1, 5, 9 };
        int[] arrayB = new int[]{ 7, 5, 9, 9, 2, 1, 3, 5, 7, 9, 1, 1, 5, 8, 8, 9, 7 };
        test(arrayA, arrayB);
    }

    private static void test(int[] arrayA, int[] arrayB) {
        System.out.println(Arrays.toString(arrayA));
        System.out.println(Arrays.toString(arrayB));
        ShortestSupersequence.shortest(arrayA, arrayB);
    }
}
