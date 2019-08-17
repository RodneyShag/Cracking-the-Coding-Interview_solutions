package _1_9_String_Rotation;

public class StringRotation {
    public static boolean isRotation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        String doubledString = s1 + s1;
        return doubledString.contains(s2);
    }
}

// Time/Space Complexities are same as .contains() function
// If .contains() is implemented using the "KMP algorithm" then we will have:
//
//  Time Complexity: O(n)
// Space Complexity: O(1)
