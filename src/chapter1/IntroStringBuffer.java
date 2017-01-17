package chapter1;

/* StringBuffer practice */
public class IntroStringBuffer {
	public static void main(String [] args){
		String [] myStrings = {"Hi ", "there ", "Rob. ", "How ", "are ", "you?"};
		System.out.println(joinWords(myStrings));
	}
	
	/* Joins an an array of strings into 1 string. Uses StringBuffer for efficiency */
	public static String joinWords(String [] strings){
		StringBuffer sentence = new StringBuffer();
		for (String string : strings){
			sentence.append(string);
		}
		return sentence.toString();
	}
}
