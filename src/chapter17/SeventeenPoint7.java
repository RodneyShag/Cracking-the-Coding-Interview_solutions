package chapter17;

/* This problem is easy, so I stopped coding it midway 
 * - convert(19,323,984) = convert(19) + " million " + convert(323) + " thousand " + convert(984)
 *   so split at the commas of a long number (into groups of 3), using a function called "numToStringl00".
 * - use "/" and "%" to get proper parts of number
 * - Don't forget to consider negative numbers, and 0 
 */
public class SeventeenPoint7 {
	public static void print(int num){
		int hundreds = num / 100;
		printDigitAsWord(hundreds);
		System.out.print(" Hundred");
		
		System.out.println();
	}
	
	/* Book instead used an array of Strings where array[1] = "One", array[2] = "Two"... This makes the code faster cuz array access is fast 
	 * In general, long if-elses that represent switch statements can instead be implemented with an array or HashMap for faster lookup
	 */
	private static void printDigitAsWord(int digit){
		if (digit == 1)
			System.out.print("One");
		else if (digit == 2)
			System.out.print("Two");
		else if (digit == 3)
			System.out.print("Three");
		else if (digit == 4)
			System.out.print("Four");
		else if (digit == 5)
			System.out.print("Five");
		else if (digit == 6)
			System.out.print("Six");
		else if (digit == 7)
			System.out.print("Seven");
		else if (digit == 8)
			System.out.print("Eight");
		else if (digit == 9)
			System.out.print("Nine");
	}
}
