package _1_6_String_Compression;

//  Time Complexity: O(n)
// Space Complexity: O(n)

public class StringCompression {
    public static String basicCompression(String str) {
        StringBuffer sb = new StringBuffer(); // StringBuffer has efficient "append" that String doesn't have
        int numSame = 1;
        for (int i = 1; i < str.length(); i++) {
            char prev = str.charAt(i-1);
            char curr = str.charAt(i);
            if (prev == curr) {
                numSame++;
            } else {
                sb.append(prev);
                sb.append(String.valueOf(numSame));
                numSame = 1;
            }
        }

        // Accounts for last character
        sb.append(str.charAt(str.length() - 1));
        sb.append(String.valueOf(numSame));

        return sb.length() < str.length() ? sb.toString() : str;
    }
}
