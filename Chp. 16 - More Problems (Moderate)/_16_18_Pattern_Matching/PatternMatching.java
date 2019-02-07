package _16_18_Pattern_Matching;

// Algorithm:
// 0) If pattern is all the same letter (aaaaa... or bbbbb...), treat it as a special case.
// 1) Invert pattern (if necessary) to have it start with "a" instead of "b"
// 2) count numAs, numBs
// 3) try maxLengthA = 1 up to max it could validly be
//      - for each maxLengthA, calculate maxLengthB
//      - use a helper function: checkMatch(String value, String pattern, int aLength, int bLength)

public class PatternMatching {

    public static boolean matches(String value, String pattern) {
        /* Special case: all same character in pattern */
        if (pattern.indexOf('a') == -1 || pattern.indexOf('b') == -1) {
            return value.length() % pattern.length() == 0; // wrong. must check if pattern properly repeats in value.
        }

        pattern = invert(pattern);
        int numAs = countOf(pattern, 'a');
        int numBs = pattern.length() - numAs;
        int maxLengthA = value.length() / numAs;
        for (int lengthA = 1; lengthA <= maxLengthA; lengthA++) {
            int charsForB = value.length() - lengthA * numAs;
            if (charsForB % numBs != 0) {
                continue;
            }
            int lengthB = charsForB / numBs;
            if (checkMatch(value, pattern, lengthA, lengthB)) {
                return true;
            }
        }
        return false;
    }

    /* Changes pattern (if necessary) to start with 'a' instead of 'b'. Example: bbaba becomes aabab */
    private static String invert(String pattern) {
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

    private static boolean checkMatch(String value, String pattern, int aLength, int bLength) {
        /* Grab the 2 words matching "a" and "b" */
        int firstBinPattern = pattern.indexOf('b');
        int firstBinValue   = firstBinPattern * aLength;
        String aWord = value.substring(0, aLength);
        String bWord = value.substring(firstBinValue, firstBinValue + bLength);

        int i = 0;
        for (int j = 0; j < pattern.length(); j++) {
            if (pattern.charAt(j) == 'a') {
                if (!value.substring(i, i + aLength).equals(aWord)) {
                    return false;
                }
                i += aLength;
            } else if (pattern.charAt(j) == 'b') {
                if (!value.substring(i, i + bLength).equals(bWord)) {
                    return false;
                }
                i += bLength;
            }
        }
        return true;
    }
}

// Time Complexity: O(n^2)
