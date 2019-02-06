package _17_15_Longest_Word;

import java.util.Arrays;

public class Tester {
    public static void main(String[] args) {
        System.out.println("*** Test 17.15: Longest Word");
        test(new String[]{ "cat", "banana", "dog", "nana", "walk", "walker", "dogwalker", "spectaculous" });
        test(new String[]{ "cat", "banana", "dog", "nana", "walk", "nanadogwalkercat", "walker", "dogwalker" });
    }

    private static void test(String[] array) {
        System.out.println("\n" + Arrays.toString(array));
        System.out.println("Solution: " + LongestWord.longestWord(array));
    }
}
