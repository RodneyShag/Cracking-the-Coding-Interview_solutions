package chapter07;

public class Chapter7 {
	public static void main(String [] args) {
		test_Prime();
		// 7.1: no code required
		// 7.2: no code required
		test_SevenPoint3();
		test_SevenPoint4();
		// 7.5: Skip: no new concepts in this problem. Only trick is that the line goes through center of 2 squares.
		test_SevenPoint6();
		test_SevenPoint7();
	}
	
	public static void test_Prime() {
		System.out.println("*** Test Primes");
		System.out.println("Is 11 prime? " + Prime.isPrime(11));
		System.out.println("Is 12 prime? " + Prime.isPrime(12));
		System.out.println("Is 13 prime? " + Prime.isPrime(13));
		boolean [] primes = Prime.generatePrimes(50);
		System.out.print("Primes from 1-50: ");
		for (int i = 0; i < primes.length; i++) {
			if (primes[i]) {
				System.out.print(i + " ");
			}
		}
	}

	public static void test_SevenPoint3() {
		System.out.println("\n\n*** Test 7.3: Intersecting Lines");
		Line line1 = new Line(new Point(2,0), new Point(2,3));
		Line line2 = new Line(new Point(2,5), new Point(2,7));
		Line line3 = new Line(new Point(1,2), new Point(3,3));
		Line line4 = new Line(new Point(2,3), new Point(4,4));

		System.out.println("Lines intersect? (should be true):  " + LineFunctions.intersect(line1, line2));
		System.out.println("Lines intersect? (should be true):  " + LineFunctions.intersect(line1, line3));
		System.out.println("Lines intersect? (should be true):  " + LineFunctions.intersect(line1, line4));
		System.out.println("Lines intersect? (should be true):  " + LineFunctions.intersect(line2, line3));
		System.out.println("Lines intersect? (should be true):  " + LineFunctions.intersect(line2, line4));
		System.out.println("Lines intersect? (should be false): " + LineFunctions.intersect(line3, line4));
		
		// Tests our Line, LineFunctions classes for functions used in 7.6
		System.out.println("\nLines intersect? (should be true):  " + LineFunctions.sameLine(line1, line2));
		System.out.println("Lines intersect? (should be false): " + LineFunctions.sameLine(line1, line3));
		System.out.println("Lines intersect? (should be false): " + LineFunctions.sameLine(line1, line4));
		System.out.println("Lines intersect? (should be false): " + LineFunctions.sameLine(line2, line3));
		System.out.println("Lines intersect? (should be false): " + LineFunctions.sameLine(line2, line4));
		System.out.println("Lines intersect? (should be false): " + LineFunctions.sameLine(line3, line4));
	}

	public static void test_SevenPoint4() {
		System.out.println("\n*** Test 7.4: Subtraction, Multiplication, Division");
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
		try {
			result = SevenPoint4.divide(7, 2);
			System.out.println(" 7 /  2 = " + result);
			result = SevenPoint4.divide(-7, 2);
			System.out.println("-7 /  2 = " + result);
			result = SevenPoint4.divide(7, -2);
			System.out.println(" 7 / -2 = " + result);
			result = SevenPoint4.divide(-7, -2);
			System.out.println("-7 / -2 = " + result);
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void test_SevenPoint6() {
		System.out.println("\n*** Test 7.6: Find line passing through most provided points");
		Point [] points = new Point[4];
		points[0] = new Point(1, 3);
		points[1] = new Point(2, 4);
		points[2] = new Point(3, 5);
		points[3] = new Point(13, 7);
		
		Line bestLine = SevenPoint6.findBestLine(points);
		System.out.println("bestLine = " + bestLine);
	}

	public static void test_SevenPoint7() {
		System.out.println("\n*** Test 7.7: find kth magic number");
		for (int i = 1; i <= 6; i++) {
			System.out.println(i + ": magic number = " + SevenPoint7.getKthMagicNumber(i));
		}
	}
}
