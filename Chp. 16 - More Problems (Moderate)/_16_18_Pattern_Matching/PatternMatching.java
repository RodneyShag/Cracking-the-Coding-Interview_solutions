package _16_18_Pattern_Matching;

// Algorithm:
// 1) If pattern is all the same letter (aaaaa... or bbbbb...), treat it as a special case.
// 2) Invert pattern (if necessary) to have it start with "a" instead of "b"
// 3) count numAs, numBs
// 4) try maxLengthA = 1 up to max it could validly be
//      - for each maxLengthA, calculate maxLengthB
//      - use a helper function: checkMatch(String value, String pattern, int aLength, int bLength)

public class PatternMatching {

    public static boolean matches(String str, String pattern) {
        if (str == null || pattern == null || pattern.length() > str.length()) {
            return false;
        } else if (pattern.length() == 0) {
            return str.length() == 0;
        } else if (pattern.indexOf('a') == -1 || pattern.indexOf('b') == -1) {
            return checkMatchRepeatingWord(str, pattern);
        }

        pattern = invertIfNecessary(pattern);
        int numAs = countOf(pattern, 'a');
        int numBs = pattern.length() - numAs;
        int maxLengthA = str.length() / numAs;
        for (int lengthA = 1; lengthA <= maxLengthA; lengthA++) {
            int charsForB = str.length() - lengthA * numAs;
            if (charsForB % numBs != 0) {
                continue;
            }
            int lengthB = charsForB / numBs;
            if (checkMatch(str, pattern, lengthA, lengthB)) {
                return true;
            }
        }
        return false;
    }

    // Changes pattern (if necessary) to start with 'a' instead of 'b'. Example: bbaba becomes aabab
    private static String invertIfNecessary(String pattern) {
        if (pattern.charAt(0) == 'a') {
            return pattern;
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < pattern.length(); i++) {
            if (pattern.charAt(i) == 'a') {
                sb.append('b');
            } else if (pattern.charAt(i) == 'b') {
                sb.append('a');
            }
        }
        return sb.toString();
    }

    private static int countOf(String str, char ch) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ch) {
                count++;
            }
        }
        return count;
    }

    private static boolean checkMatchRepeatingWord(String str, String pattern) {
        int wordLength = str.length() / pattern.length();
        String word = str.substring(0, wordLength);
        for (int i = 0; i < str.length(); i += word.length()) {
            if (!str.substring(i, i + word.length()).equals(word)) {
                return false;
            }
        }
        return true;
    }
    
    private static boolean checkMatch(String str, String pattern, int aLength, int bLength) {
        // Grab the 2 words matching "a" and "b"
        int firstBinPattern = pattern.indexOf('b');
        int firstBinValue = firstBinPattern * aLength;
        String aWord = str.substring(0, aLength);
        String bWord = str.substring(firstBinValue, firstBinValue + bLength);

        int i = 0;
        for (int j = 0; j < pattern.length(); j++) {
            if (pattern.charAt(j) == 'a') {
                if (!str.substring(i, i + aLength).equals(aWord)) {
                    return false;
                }
                i += aLength;
            } else if (pattern.charAt(j) == 'b') {
                if (!str.substring(i, i + bLength).equals(bWord)) {
                    return false;
                }
                i += bLength;
            }
        }
        return true;
    }
}

// Time Complexity: O(n^2)
// Space Complexity: O(n)
