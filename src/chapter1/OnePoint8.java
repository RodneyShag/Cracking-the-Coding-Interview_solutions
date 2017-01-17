package chapter1;

public class OnePoint8 {
	public static void main(String [] args){
		test("waterbottle", "erbottlewat");
		test("", "erbottlewat");
		test("tooth", "candy");
	}
	
	/* CLEVER TRICK from book */
	public static boolean isRotation(String s1, String s2){
		if (s1.length() != s2.length())
			return false;
		
		String doubledString = s1 + s1;
		return doubledString.contains(s2);
	}
	
	/* Tests code */
	private static void test(String s1, String s2){
		System.out.println(s1 + ", " + s2 + "  --> " + isRotation(s1, s2));
	}
}