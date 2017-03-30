package chapter01;

public class OnePoint4 {
	/* To simplify finding "true length", we assume specific Strings:
	 * Strings with 2 spaces to replace and 4 blank spaces at end.
	 */
	public static void replaceWhitespace(char [] sentence, int trueLength) {
		/* Count number of spaces to determine updated length of string */
		int numberOfSpaces = 0;
		for (int i = 0; i < trueLength; i++) {
			if (sentence[i] == ' ') {
				numberOfSpaces++;
			}
		}
		
		/* Replace each space with %20 */
		if (numberOfSpaces > 0) {
			int j = trueLength - 1 + numberOfSpaces * 2; // adds an additional 2 spots for each space.
			for (int i = trueLength - 1; i >= 0; i--) {
				if (sentence[i] == ' ') {
					sentence[j-2] = '%';
					sentence[j-1] = '2';
					sentence[j] = '0';
					j = j - 3;
				} else {
					sentence[j] = sentence[i];
					j--;
				}
			}
		}
	}
}
