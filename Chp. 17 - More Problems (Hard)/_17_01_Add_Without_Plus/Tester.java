package _17_01_Add_Without_Plus;

public class Tester {
	public static void main(String[] args) {
		System.out.println("*** Test 17.1: Add Without Plus\n");
		test(17, 34);
		test(-17, 34);
		test(17, -34);
		test(-17, -34);
		System.out.println();
		test_2(17, 34);
		test_2(-17, 34);
		test_2(17, -34);
		test_2(-17, -34);
		System.out.println();
		test(9, 65);
		test(-9, 65);
		test(9, -65);
		test(-9, -65);
		System.out.println();
		test_2(9, 65);
		test_2(-9, 65);
		test_2(9, -65);
		test_2(-9, -65);
	}
	
	private static void test(int a, int b) {
		System.out.format("%3d + %3d = %3d\n", a, b, AddWithoutPlus.add(a, b));
	}
	
	private static void test_2(int a, int b) {
		System.out.format("%3d + %3d = %3d\n", a, b, AddWithoutPlus.add_version2(a, b));
	}
}
