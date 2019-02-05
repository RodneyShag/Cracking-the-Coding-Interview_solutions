package _1_3_URLify;

public class URLify {
    public static void replaceWhitespace(char[] sentence, int trueLength) {
        /* Count number of spaces */
        int numSpaces = 0;
        for (int i = 0; i < trueLength; i++) {
            if (sentence[i] == ' ') {
                numSpaces++;
            }
        }
        /* Replace each space with %20 */
        if (numSpaces > 0) {
            int j = trueLength - 1 + numSpaces * 2; // adds an additional 2 spots for each space.
            for (int i = trueLength - 1; i >= 0; i--) {
                if (sentence[i] == ' ') {
                    sentence[j-2] = '%';
                    sentence[j-1] = '2';
                    sentence[j]   = '0';
                    j = j - 3;
                } else {
                    sentence[j] = sentence[i];
                    j--;
                }
            }
        }
    }
}
