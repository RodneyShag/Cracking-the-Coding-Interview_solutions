package _1_4_Palindrome_Permutation;

import java.util.*;

public class PalindromePermutation {
    
    private static final int NUM_LOWERCASE_LETTERS = 26;
    
    public static boolean palPerm(String str) {
        str = str.toLowerCase().replaceAll("\\s", "");
        Map<Character, Integer> map = new HashMap<>(NUM_LOWERCASE_LETTERS);
        for (int i = 0; i < str.length(); i++) {
            Character ch = str.charAt(i);
            if (Character.isLetter(ch)) {
                map.merge(ch, 1, Integer::sum);
            }
        }
        
        //  Odd length strings: Can have at most 1 character an odd # of times
        // Even length strings: Can have either 0,2,4,6... number of odd characters.
        //                      Anything above 1 means not a palindrome.
        int oddCount = 0;
        for (Integer value : map.values()) {
            if (value % 2 != 0) {
                oddCount++;
            }
            if (oddCount > 1) {
                return false;
            }
        }
        return true;
    }
}

//  Time Complexity: O(n)
// Space Complexity: O(1)
