package chapter1;

public class OnePoint4 {
	public static void main (String [] args){
		char [] sentence = {'D', 'a', 'd', ' ', 'i', 's', ' ', 's', 'm', 'a', 'r', 't', '\0', '\0', '\0', '\0'};
		System.out.println(sentence);
		replaceWhitespace(sentence, sentence.length - 4);
		System.out.println(sentence);
	}
	
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
}
