package _1_2_Check_Permutations;

// Should ask interviewer if String is ASCII or Unicode (We assume ASCII)

// Algorithm:
// Count the different characters using an array (as shown below) or a HashMap.
// For each String, we can save the count of each character in an array, then compare these 2 arrays.
// However, instead of using 2 arrays, we can do it with 1, as shown below.


public class CheckPermutations {
    private static final int NUM_ASCII_CHARS = 256; // number of ASCII characters
    public static boolean isPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        int[] letters = new int[NUM_ASCII_CHARS];
        for (int i = 0; i < s1.length(); i++) {
            char ch = s1.charAt(i);
            letters[ch]++;
        }
        for (int i = 0; i < s2.length(); i++) {
            char ch = s2.charAt(i);
            if (--letters[ch] < 0) {
                return false;
            }
        }
        return true;
    }
}


//  Time Complexity: O(n)
// Space Complexity: O(1)
