package _8_14_Boolean_Evaluation;

public class Tester {
	public static void main(String[] args) {
		System.out.println("*** Test 8.14: Boolean Evaluation\n");
		test("1^0|0|1", false);
	}
	
	private static void test(String str, boolean bool) {
		System.out.format("# of ways to parenthesize %s to be %s = %d\n", str, bool, BooleanEvaluation.f(str, bool));
	}
}
