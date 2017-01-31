package chapter17;

public class SeventeenPoint01 {
	public static void swap(int a, int b){
		System.out.println("Original: a = " + a + "  b = " + b);
		a = a - b;
		b = b + a;
		a = b - a;
		System.out.println("Swapped:  a = " + a + "  b = " + b);
	}
	
	public static void swap_opt(int a, int b){
		System.out.println("Original: a = " + a + "  b = " + b);
		a = a ^ b;
		b = a ^ b;
		a = a ^ b;
		System.out.println("Swapped:  a = " + a + "  b = " + b);
	}
}
