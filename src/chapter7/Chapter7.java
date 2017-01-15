package chapter7;

public class Chapter7 {
	public static void main (String [] args){
		/*** 7.4 ***/
		System.out.println("*** Test 7.4");
		int result = SevenPoint4.subtract(4, 7);
		System.out.println(" 4 -  7 = " + result + "\n");

		result = SevenPoint4.multiply(2, 3);
		System.out.println(" 2 *  3 = " + result);
		result = SevenPoint4.multiply(-2, 3);
		System.out.println("-2 *  3 = " + result);
		result = SevenPoint4.multiply(2, -3);
		System.out.println(" 2 * -3 = " + result);
		result = SevenPoint4.multiply(-2, -3);
		System.out.println("-2 * -3 = " + result + "\n");
		
		result = SevenPoint4.divide(7, 2);
		System.out.println(" 7 /  2 = " + result);
		result = SevenPoint4.divide(-7, 2);
		System.out.println("-7 /  2 = " + result);
		result = SevenPoint4.divide(7, -2);
		System.out.println(" 7 / -2 = " + result);
		result = SevenPoint4.divide(-7, -2);
		System.out.println("-7 / -2 = " + result);
		
		//7.6 -- I know how to code it, so I skipped it. Book's code/explanation is weird cuz they do line segments and complicate stuff.
		//Things to remember: ( y = mx + b) (The solution line must go through middle of squares)

		/*** 7.6 ***/		
		System.out.println("\n*** Test 7.6");
		Point [] points = new Point[4];
		points[0] = new Point(1, 3);
		points[1] = new Point(2, 4);
		points[2] = new Point(3, 5);
		points[3] = new Point(13, 7);
		
		Line bestLine= SevenPoint6.findBestLine(points);
		System.out.println("bestLine:   Slope = " + bestLine.slope + "   Intercept = " + bestLine.intercept);
		
		/*** 7.7 ***/		
		System.out.println("\n*** Test 7.7");
		System.out.println("\n Solution 1");
		for (int i = 1; i <= 6; i++){
			System.out.println(i + ": magic number = " + SevenPoint7.getKthMagicNumber(i));
		}
		System.out.println("\n Solution 2");
		for (int i = 1; i <= 6; i++){
			System.out.println(i + ": magic number = " + SevenPoint7.getKthMagicNumber2(i));
		}
	}
}
