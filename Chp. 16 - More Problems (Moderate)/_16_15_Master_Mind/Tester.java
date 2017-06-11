package _16_15_Master_Mind;

public class Tester {
	public static void main(String[] args) {
		System.out.println("*** Test 16.15: Master Mind");
		test("RGBY", "GGRR");
		test("RRRG", "GGRR");
		test("YYBY", "BBBB");
	}
	
	private static void test(String s1, String s2) {
		System.out.format("\nSolution = %s\nGuess    = %s\n%s\n", s1, s2, MasterMind.estimate(s1, s2));
	}
}
