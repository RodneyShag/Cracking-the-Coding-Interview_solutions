// github.com/RodneyShag

package _1_2_Check_Permutations;

import java.util.HashMap;

// Should ask interviewer if String is ASCII or Unicode (We assume ASCII)

// Algorithm
//
// Do a quick check on string lengths. If the lengths differ, the strings can't be anagrams
// Save `String s` as `HashMap` of character counts
// For `String t`, see if it can be made up of the characters of the previous `HashMap`

public class CheckPermutations {

    private static final int NUM_ASCII_CHARS = 256;

    public static boolean isPermutation(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Integer> map = new HashMap(NUM_ASCII_CHARS);
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.merge(ch, 1, Integer::sum);
        }
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            if (!map.containsKey(ch) || map.get(ch) == 0) {
                return false;
            }
            map.merge(ch, -1, Integer::sum);
        }
        return true;
    }
}

//  Time Complexity: O(n)
// Space Complexity: O(1)
