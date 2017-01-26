package chapter05;

import java.util.ArrayList;
import java.util.Iterator;

/* Find missing number from 0 to n
 * 
 * Solutions                      Runtime       Preference
 * -------------------------------------------------------
 * 1) n(n+1)/2 trick              O(n log n)    Naive
 * 2) Fancy bit trick solution    O(n)          Favorite
 */
public class FivePoint7 {
	/* Solution 1 (from 1st 3 paragraphs in book)
	 * Mention the n * (n+1)/2 solution in an interview, even though it's O(n log n) time.*/
	
	/* Solution 2: Read book's explanation, but ignore its recursive code. See my code below instead.
	 * - I coded the book's recursive explanation iteratively.
	 * - Uses "BitInteger" class (from book) which I found online
	 * - Runtime: n + n/2 + n/4 + n/8 ... = n * (1 + 1/2 + 1/4 + 1/8 ...) = 2n = O(n)
	 */
	public static int findMissing(ArrayList<BitInteger> array){
		int zeroBits = 0;
		int oneBits  = 0;
		BitInteger missingNum = new BitInteger();
		for (int i = 0; i < BitInteger.INTEGER_SIZE; i++){	//I manually set this to 3 in BitInteger code.
			/* Count number of 1's and 0's in digit i */
			for (BitInteger num: array){
				if (num.fetch(i) == 1)
					oneBits++;
				else
					zeroBits++;
			}
			
			Iterator<BitInteger> iterator = array.iterator(); // we use an Iterator since it's the safe way to remove elements from a Collection while looping through it.
			if (zeroBits > oneBits){
				missingNum.set(i, 1);
				
				/* Remove Non-similar Numbers. (Book explains why this works). */
				while (iterator.hasNext()) {
				    if (iterator.next().fetch(i) == 0)	//Tricky: I think the .next() automatically makes the iterator point to the next thing
				    	iterator.remove();
				}
			}
			else{
				missingNum.set(i, 0);
				while (iterator.hasNext()) {
				    if (iterator.next().fetch(i) == 1)	
				    	iterator.remove();
				}
			}
			zeroBits = 0;
			oneBits = 0;
		}
		return missingNum.toInt();
	}
}
