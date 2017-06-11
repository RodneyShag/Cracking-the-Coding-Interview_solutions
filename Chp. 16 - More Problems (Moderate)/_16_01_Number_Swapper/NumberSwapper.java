package _16_01_Number_Swapper;

public class NumberSwapper {
	public static void swap1(int a, int b) {
		a = a - b;
		b = b + a;
		a = b - a;
		System.out.println("Swapped (Solution 1): a = " + a + "  b = " + b);
	}

	public static void swap2(int a, int b) {
		a = a ^ b;
		b = a ^ b;
		a = a ^ b;
		System.out.println("Swapped (Solution 2): a = " + a + "  b = " + b);
	}
}
