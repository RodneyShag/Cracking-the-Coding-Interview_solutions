package _16_18_Pattern_Matching;

public class Tester {
	public static void main(String[] args) {
		System.out.println("*** Test 16.18: Pattern Matching");
		test("catcatgocatgo", "aabab");
		test("catcatgocatgo", "bab");
		
	}
	
	private static void test(String value, String pattern) {
		System.out.println("\nvalue =   " + value);
		System.out.println("pattern = " + pattern);
		System.out.println("Matches?: " + PatternMatching.matches(value, pattern));
	}
}
