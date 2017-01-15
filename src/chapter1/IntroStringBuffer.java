package chapter1;

public class IntroStringBuffer {
	public static void main(String [] args){
		String [] myStrings = {"Hi ", "there ", "Rob"};
		System.out.println(joinWords(myStrings));
	}
	
	public static String joinWords(String [] strings){
		StringBuffer sentence = new StringBuffer();
		for (String string : strings){
			sentence.append(string);
		}
		return sentence.toString();
	}
}
