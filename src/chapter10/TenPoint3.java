package chapter10;
import java.util.Scanner;
import java.io.*;	//so it has "FileNotFoundException" and "FileReader"

/* Just use BitSet! Below algorithm doesn't use it. Can also look at my own BitSet class I created in this folder */

/* Testing this causes: "java.lang.OutOfMemoryError: Java heap space" since we need 1GB of memory as problem suggests
 * - Tricky part is knowing how to represent 4 billion bits in a row since our array groups them into groups of 8.
 * - bitfield[n/8] |= (1 << (n % 8)) is the juicy line!
 * - memorize the algorithm (which is in the comments)
 *  */
public class TenPoint3 {

	public static void findOpenNumber() throws FileNotFoundException{
		long numberOfInts = ((long) (Integer.MAX_VALUE)) + 1;
		byte [] bitfield = new byte[(int) (numberOfInts / 8)];
		
		/* Initialize bitfield to represent numbers we already have */
		Scanner in = new Scanner(new FileReader("numbers.txt"));	//reading in file is copied code from book, without me caring to understand it.
		while (in.hasNextInt()){
			int n = in.nextInt();
			bitfield[n/8] |= (1 << (n % 8));	//this is the juicy line that makes everything work.
		}
		
		/* Find first bit that is 0 and print corresponding number */
		for (int i = 0; i < bitfield.length; i++){
			for (int j = 0; j < 8; j++){
				if ((bitfield[i] & (1 << j)) == 0){
					System.out.println(i*8+j);
					in.close();
					return;
				}
			}
		}
		in.close();
	}
	
	
	/* Notes for follow-up: Using 10 MB Space. Memorize Overall 2-pass Algorithm. Code is super tricky and straight from book
	 * - 10 MB = 2 ^ 23 Bytes = 2 ^ 26 Bits
	 * 		- so rangeSize must be <= 2^26 Bits
	 *		- and rangeSize >= 2^10 bits (see book explanation)
	 * */
	public static void findOpenNumber2() throws FileNotFoundException{
		int bitsize = 1048576;	// 2^20 bits (2^17 bytes).	Size decided from logic shown above
		int numBlocks = 4096;	// 2^12 bits
		byte[] bitfield = new byte[bitsize/8];	//this is our "bitvector"
		int [] blocks = new int[numBlocks];		//keep in mind we are NOT using this as a bitvector

		int starting = -1;
		Scanner in = new Scanner(new FileReader ("file.txt"));
		
		/* Set up each block to have the count of numbers in that range */
		while (in.hasNextInt()){
			int n = in.nextInt();
			blocks[n / bitsize]++;
		}
		
		/* Find 1st block that's missing a number */
		for (int i = 0; i < blocks.length; i++){
			if (blocks[i] < bitsize){
				starting = i * bitsize;
				break;
			}
		}
		
		//the next 2 parts are very similar to solution 1.
		
		/* Do 2nd pass of file of numbers and record them into bitfield */
		in = new Scanner(new FileReader ("file.txt"));
		while (in.hasNextInt()){
			int n = in.nextInt();
			if (n >= starting && n < starting + bitsize){
				bitfield[(n - starting) / 8] |= 1 << ((n - starting) % 8);
			}
		}
		
		/* Loop through bitfield and print the 1st missing number */
		for (int i = 0; i < bitfield.length; i++){
			for (int j = 0; j < 8; j++){
				if ((bitfield[i] & (1 << j)) == 0){
					System.out.println(starting + (i * 8) + j);
					in.close();
					return;
				}
			}
		}
		in.close();
	}
}
