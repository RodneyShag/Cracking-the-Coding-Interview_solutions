package chapter7;

public class SevenPoint4 {
	
	public static int subtract(int a, int b){
		return a + negate(b);
	}
	
	/* Careful on multiplying negative numbers. 
	 * Another way to think about it is (which is not implemented here but implemented in "divide" function): 
	 * Convert both #s to positive. Do multiplication. Then negate if necessary.
	 */
	public static int multiply(int a, int b){
		if (b > a)
			return multiply(b, a);	//since this will be faster

		int result = 0;
		for (int i = 0; i < Math.abs(b); i++){	//we do Math.abs so we can properly multiply negative numbers.
			result += a;
		}
		if (b < 0)
			result = negate(result);
		return result;
	}
	
	/* Algorithm is from book. But my code is coincidentally the same as book's */
	public static int divide(int a, int b){
		//would have to do error check for (b == 0) here. Would use "throw Exception"
		boolean negativeResult = (a > 0 && b < 0) || (a < 0 && b > 0);
		a = Math.abs(a);
		b = Math.abs(b);
		
		/* This part is the main algorithm */
		int result = 0;
		while (b * result < a){
			result++;
		}
		
		if (b * result != a)	//this will "floor" it.
			result--;
		if (negativeResult)
			result = negate2(result);
		return result;
	}
	
	private static int negate(int a){
		//return (a ^ 0xFFFFFFFF) + 1;	//My 1st solution using XOR. (assumes 32-bit int)
		return ~a + 1;					//My 2nd solution. Also works.
	}
	
	/* Book's negate solution is also clever */
	private static int negate2(int a){
		int neg = 0;
		int d = (a < 0) ? 1 : -1;		//I mistakenly had this as (a > 0) for the longest time
		while (a != 0){
			a += d;
			neg += d;
		}
		return neg;
	}
}
