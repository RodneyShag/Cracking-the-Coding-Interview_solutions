package chapter1;

public class OnePoint8 {
	public static void main(String [] args){
		/* Test #1 */
		String s1 = "waterbottle";
		String s2 = "erbottlewat";
		if (isRotation(s1, s2))
			System.out.println("yes");
		else
			System.out.println("no");
		
		/* Test #2 */
		s1 = "";
		s2 = "erbottlewat";
		if (isRotation(s1, s2))
			System.out.println("yes");
		else
			System.out.println("no");
	}
	
	/* CLEVER TRICK from book */
	public static boolean isRotation(String s1, String s2){
		/* Error Checking */
		if (s1.length() != s2.length())
			return false;
		
		String doubledString = s1 + s1;
		return doubledString.contains(s2);
	}
}