package _1_4_Palindrome_Permutation;

import java.util.HashMap;

public class PalindromePermutation {
    public static boolean palPerm(String str) {
        /* Create HashMap to count characters in String */
        str = str.toLowerCase().replaceAll("\\s", "");
        HashMap<Character, Integer> map = new HashMap<>(26);
        for (int i = 0; i < str.length(); i++) {
            Character ch = str.charAt(i);
            if (Character.isLetter(ch)) {
                map.merge(ch, 1, Integer::sum);
            }
        }

        // Even length strings: can not have any characters an odd # of times
        // Odd length strings: can have at most 1 character an odd # of times
        int exceptions = (str.length() % 2 == 0) ? 0 : 1;
        for (Integer value : map.values()) {
            if (value % 2 != 0) {
                exceptions--;
            }
            if (exceptions < 0) {
                return false;
            }
        }
        return true;
    }
}
