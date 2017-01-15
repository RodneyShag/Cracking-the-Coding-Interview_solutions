package chapter5;
import java.util.ArrayList;
import java.util.Iterator;

public class FivePoint7 {
	/* Book Mentioned Solution: n * (n+1)/2 solution is definitely worth mentioning in an interview, even though it's O(n log n) time. */
	
	/* Solution 2: SKIP IT (algorithm is too detailed/complicated)
	 * Rodney Solution: Iterative version of book's recursive solution.
	 * I coded the book's algorithm iteratively, using "BitInteger" (from book) which I found online (and slightly altered)'
	 * My solution was O(n log n) since the INTEGER_SIZE grows as log(n) as n gets bigger.
	 * But then, I removed BitIntegers from array as the book said, so my solution is O(n)
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
			
			Iterator<BitInteger> iterator = array.iterator();
			if (zeroBits > oneBits){
				missingNum.set(i, 1);
				/* Remove Nonsimilar Numbers. (Book explain why this works). This is what makes my code go from O(n log n) to O(n) time */
				while (iterator.hasNext()) {
				    if (iterator.next().fetch(i) == 0)	//Tricky: I think the .next() automatically makes the iterator point to the next thing
				    	iterator.remove();
				}
			}
			else{
				missingNum.set(i, 0);
				/* Remove Nonsimilar Numbers. (Book explains why this works). This is what makes my code go from O(n log n) to O(n) time */
				while (iterator.hasNext()) {
				    if (iterator.next().fetch(i) == 1)	//Tricky: I think the .next() automatically makes the iterator point to the next thing
				    	iterator.remove();
				}
			}
			zeroBits = 0;
			oneBits = 0;
		}
		return missingNum.toInt();
	}
}