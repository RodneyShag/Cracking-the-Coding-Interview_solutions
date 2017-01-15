package chapter17;

public class SeventeenPoint1 {
	public static void swap(int a, int b){
		a = a - b;
		b = b + a;
		a = b - a;
	}
	
	/* Skip this */
	public static void swap_opt(int a, int b){
		a = a ^ b;
		b = a ^ b;
		a = a ^ b;
	}
}
