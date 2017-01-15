package chapter5;

public class FivePoint3 {
	/* Solution 1 - Rodney's Solution - Mentioned as "Brute Force" from book */
	public static void printSmallerLarger(int num){
		if (num < 0)
			return;
		int ones = BitFunctions.numOnes(num);
		int smaller = num - 1;
		int larger = num + 1;
		while (smaller >= 0 && BitFunctions.numOnes(smaller) != ones){
			smaller--;
		}
		while (larger < Integer.MAX_VALUE && BitFunctions.numOnes(larger) != ones){
			larger++;
		}
		System.out.println("\nOriginal = " + num);
		System.out.println("Smaller = " + smaller);	//will print -1 if there is not a smaller solution
		System.out.println("Larger = " + larger);	//will probably print Integer.MAX_VALUE if there is not a larger solution

	}
	
	/* Solution 2 - The algorithm is from the book, but my code is completely different. I like my version better 
	 * Memorize the algorithm, not the code.
	 */
	public static int getNext(int num){
		int indexOfZero = -1;
		int c0 = 0; //count of 0's. We never use this, but if I was coding this for the first time in an interview, it'd be useful to have.
		int c1 = 0; //count of 1's
		
		/* Step 1 - Find and Flip rightmost non-trailing 0 */
		for (int i = 0; i < 32; i++){
			boolean bit = BitFunctions.getBit(num, i);
			if(!bit && c1 > 0){
				indexOfZero = i;
				break;
			}
			if (bit)
				c1++;
			else
				c0++;	
		}
		if (indexOfZero == -1)
			return -1; //Error. Could happen on a 32-bit binary number like 1111....0000, or any number which is a bunch of 1's followed by a bunch of zeros 
		
		num = BitFunctions.setBit(num, indexOfZero);

		/* Step 2 - Clear bits to the right of the index. */
		num = BitFunctions.clearBitsIthrough0(num, indexOfZero - 1);

		/* Step 3 - Add in c1 - 1 ones */
		for (int i = 0; i < c1 - 1; i++){
			num = BitFunctions.setBit(num, i);
		}
		return num;
	}
	
	public static int getPrev(int num){
		int indexOfOne = -1;
		int c0 = 0; //count of 0's. We never use this, but if I was coding this for the first time in an interview, it'd be useful to have.
		int c1 = 0; //count of 1's. 

		/* Step 1 - Find and Clear the rightmost non-trailing 1 */
		for (int i = 0; i < 32; i++){
			boolean bit = BitFunctions.getBit(num, i);
			if(bit && c0 > 0){
				indexOfOne = i;
				break;
			}
			if (bit)
				c1++;
			else
				c0++;
		}
		if (indexOfOne == -1)
			return -1; //Error. Could happen on a 32-bit binary number like 0000....1111, or any number which is a bunch of 0's followed by a bunch of 1's 
		
		num = BitFunctions.clearBit(num, indexOfOne);

		/* Step 2 - Clear bits to the right of the index. */
		num = BitFunctions.clearBitsIthrough0(num, indexOfOne - 1);

		/* Step 3 - Add in c1 + 1 ones immediatelly to the right of the cleared bit */
		int onesToAdd = c1 + 1;
		int i = indexOfOne - 1;
		while(onesToAdd > 0){
			num = BitFunctions.setBit(num, i);
			onesToAdd--;
			i--;
		}
		
		return num;
	}
	
	/* Solution 3 - Arithmetic Approach: I totally understood it, but it's a stupid way to solve the problem since it's jumbles up
	 *              too many steps together into 1 long expression, for no real benefit.
	 */
}
