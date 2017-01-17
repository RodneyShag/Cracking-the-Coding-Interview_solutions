package chapter1;

public class OnePoint4 {
	/* Important: To simplify finding "true length", we only use Strings with 2 spaces to replace,
	 *            and 4 blank spaces at end */
	public static void main (String [] args){
		test("Dad is smart    ");
	}
	
	/* Replaces whitespace in char[] with %20 */
	public static void replaceWhitespace(char [] sentence, int trueLength){
		/* Strings are immutable in JAVA. That's why the book had us use a character array */
		int numberOfSpaces = 0;
		for (int i = 0; i < trueLength; i++){
			if (sentence[i] == ' ')
				numberOfSpaces++;
		}
		if (numberOfSpaces > 0){
			int j = trueLength - 1 + numberOfSpaces * 2; //adds an additional 2 spots for each space.
			for (int i = trueLength - 1; i >= 0; i--, j--){
				if (sentence[i] == ' '){
					sentence[j-2] = '%';
					sentence[j-1] = '2';
					sentence[j] = '0';
					j = j - 2;
				}
				else{
					sentence[j] = sentence[i];
				}
			}
		}
	}
	
	/* Tests code */
	private static void test(String s){
		char [] sentence = s.toCharArray();
		System.out.println(sentence);
		replaceWhitespace(sentence, sentence.length - 4); // -4 is hard-coded.
		System.out.println(sentence);
		System.out.println();
	}
}
