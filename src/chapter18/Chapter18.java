package chapter18;

public class Chapter18 {
	public static void main (String [] args){
		/********/
		/* 18.1 */
		/********/
		System.out.println("*** Test 18.1: Add 2 numbers (without using +)");
		System.out.println("17 + 34 = " + EighteenPoint1.add(17, 34));
		System.out.println("-17 + 34 = " + EighteenPoint1.add(-17, 34));
		System.out.println("17 + -34 = " + EighteenPoint1.add(17, -34));
		System.out.println("-17 + -34 = " + EighteenPoint1.add(-17, -34));
		System.out.println();
		System.out.println("17 + 34 = " + EighteenPoint1.addBook(17, 34));
		System.out.println("-17 + 34 = " + EighteenPoint1.addBook(-17, 34));
		System.out.println("17 + -34 = " + EighteenPoint1.addBook(17, -34));
		System.out.println("-17 + -34 = " + EighteenPoint1.addBook(-17, -34));
		System.out.println();
		System.out.println("9 + 234 = " + EighteenPoint1.add(9, 234));
		System.out.println("-9 + 234 = " + EighteenPoint1.add(-9, 234));
		System.out.println("9 + -234 = " + EighteenPoint1.add(9, -234));
		System.out.println("-9 + -234 = " + EighteenPoint1.add(-9, -234));
		System.out.println();
		System.out.println("9 + 234 = " + EighteenPoint1.addBook(9, 234));
		System.out.println("-9 + 234 = " + EighteenPoint1.addBook(-9, 234));
		System.out.println("9 + -234 = " + EighteenPoint1.addBook(9, -234));
		System.out.println("-9 + -234 = " + EighteenPoint1.addBook(-9, -234));
		
		// 18.2 - Can't test true randomness
		// 18.3 - Can't test true randomness
		
		/********/
		/* 18.4 */
		/********/
		System.out.println("\n *** Test 18.4: ");
		System.out.println("Solution 1 - Count 2s: " + EighteenPoint4.count2s(99));
		System.out.println("Solution 2 - Count 2s: " + EighteenPoint4.count2sInRange(99));
		System.out.println("Solution 1 - Count 2s: " + EighteenPoint4.count2s(23212));
		System.out.println("Solution 2 - Count 2s: " + EighteenPoint4.count2sInRange(23212));

		//18.5 - Was too lazy to test since Solution 1 matched book/web code, and Solution 1 just has an important algorithm.
		
		/********/
		/* 18.6 */
		/********/
		System.out.println("\n *** Test 18.6: n (well n-1) smallest elements");
		int [] array = {52, 14, 16, 17, 26, 31, 16, 0, 6, 19, 6, 26, 14, 26, 22, 25};
		for (int i = 0; i < array.length; i++){
			System.out.print(array[i] + " ");
		}
		System.out.print("\n3 Smallest: ");
		EighteenPoint6.select(array, 3);
		System.out.print("\n8 Smallest: ");
		EighteenPoint6.select(array, 8);
		System.out.print("\n12 Smallest: ");
		EighteenPoint6.select(array, 12);
		
		/********/
		/* 18.7 */
		/********/
		System.out.println("\n\n *** Test 18.7: word combinations");
		String [] array2 = {"cat", "banana", "dog", "nana", "walk", "walker", "dogwalker", "spectaculious"};
		String [] array3 = {"cat", "banana", "dog", "nana", "walk", "nanadogwalkercat", "walker", "dogwalker"};

		System.out.print("Array A: ");
		for (int i = 0; i < array2.length; i++){
			System.out.print(array2[i] + " ");
		}
		System.out.println();
		System.out.print("Array B: ");
		for (int i = 0; i < array3.length; i++){
			System.out.print(array3[i] + " ");
		}
		
		String longestComboWord = EighteenPoint7.longestWord(array2);
		System.out.println("\n\nFind longest word composed of other words (Array A): " + longestComboWord + "");

		longestComboWord = EighteenPoint7.longestWord(array3);
		System.out.println("Find longest word composed of other words (Array B): " + longestComboWord);

		//18.8 - Suffix Tree (Skipped)
		//18.9 - No need to test. Code same as book
		//18.10 - No need to test. Code same as book
		//18.11 - No need to test. Code same as book
		//18.12 - Too lazy to test. Code is from book & website.
	}
}
