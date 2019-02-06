/** Tips **/

// Should ask interviewer if String is ASCII or Unicode (We assume ASCII)

/** Algorithm **/

// Use a HashMap to store characters and detect duplicates.

/** Solution **/

package _1_1_Is_Unique;

import java.util.HashSet;

public class IsUnique {
    private static final int NUM_CHARS = 256; // number of ASCII characters

    public static boolean uniqueCharacters(String str) {
        if (str.length() > NUM_CHARS) {
            return false;
        }
        HashSet<Character> mySet = new HashSet<>(NUM_CHARS);
        for (int i = 0; i < str.length(); i++) {
            if (mySet.contains(str.charAt(i))) {
                return false;
            } else {
                mySet.add(str.charAt(i));
            }
        }
        return true;
    }
}

/** Time/Space Complexity **/

//  Time Complexity: O(1)
// Space Complexity: O(1)
// Checking for str.length() > 256 lowered our time/space complexity from O(n) to O(1)

/** Follow-up Question **/

// What if we're not allowed to use additional data structures?

/** Follow-up Answer **/

// Do a brute-force solution using nested loops to compare all pairs.
// This will be O(n^2) time complexity and O(1) space complexity.
