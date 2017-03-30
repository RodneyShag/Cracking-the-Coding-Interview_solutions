package chapter10;

import java.util.Scanner;
import java.io.*;	      // has "FileNotFoundException" which is needed to create a "FileReader"
import java.util.BitSet;

public class TenPoint3 {

	public static final long ONE_GB = 8000000000L; // 8 billion bits
	
	/* Can't test this function since needs 1 GB of memory */
	public static void findOpenNumber() throws FileNotFoundException {
		MyBitSet bitset = new MyBitSet(ONE_GB); // My implementation of BitSet has constructor that takes a long (java.util.BitSet doesn't)
	
		Scanner scan = new Scanner(new FileReader("src/chapter10/numbers"));
		
		/* Initialize bitfield to represent numbers we already have */
		while (scan.hasNextInt()) {
			int n = scan.nextInt();
			bitset.set(n);
		}
		
		/* Find first bit that is 0 and print corresponding number */
		for (int i = 0; i < bitset.size(); i++) {
			boolean bit = bitset.get(i);
			if (!bit) {
				System.out.println("(Solution 1) Missing number (should be 20) = " + i);
				break;
			}
		}
		scan.close();
	}
	
	/*********************/
	/***** Follow-up *****/
	/*********************/

	/* - 1 billion numbers is less than 2^30. 
	 * - We have 10 MB. 1 MB is 2^20 Bytes. So 10 MB is between 2^23 and 2^24 BYTES, which is between 2^26 and 2^27 BITS.
	 *   (I solve it with less than 2^19 bits)
	 */
	public static void findOpenNumber2() throws FileNotFoundException {
		int partitionSize = (int) Math.pow(2, 18);
		int numBlocks     = (int) Math.pow(2, 12);
		BitSet bitset = new BitSet(partitionSize); // this takes up 2^18 bits
		int [] blocks = new int[numBlocks];        // this takes up 2^12 * (2^5 bits in int) = 2^17 bits
		
		Scanner scan = new Scanner(new FileReader("src/chapter10/numbers"));
		
		/* Set up each block to have the count of numbers in that range */
		while (scan.hasNextInt()) {
			int num = scan.nextInt();
			blocks[num / partitionSize]++;
		}
		
		/* Find 1st block that's missing a number */
		int lowerBound = -1;
		for (int i = 0; i < numBlocks; i++) {
			if (blocks[i] < partitionSize) {
				lowerBound = i * partitionSize;
				break;
			}
		}
		
		// The next 2 parts are very similar to part A of this problem.
		
		/* Do 2nd pass of file of numbers and record them into bitset */
		scan = new Scanner(new FileReader ("src/chapter10/numbers"));
		while (scan.hasNextInt()) {
			int n = scan.nextInt();
			if (n >= lowerBound && n < lowerBound + partitionSize) {
				bitset.set(n - lowerBound);
			}
		}
		scan.close();
		
		/* Loop through bitset and print the 1st missing number */
		for (int i = 0; i < bitset.size(); i++) {
			boolean bit = bitset.get(i);
			if (!bit) {
				System.out.println("(Solution 2) Missing number (should be 20) = " + i);
				break;
			}
		}

	}
}
