package chapter01;

public class IntroStringBuffer {
	/* Joins an an array of strings into 1 string. Uses StringBuffer for efficiency */
	public static String joinWords(String [] strings) {
		StringBuffer sentence = new StringBuffer();
		for (String string : strings) {
			sentence.append(string);
		}
		return sentence.toString();
	}
}
