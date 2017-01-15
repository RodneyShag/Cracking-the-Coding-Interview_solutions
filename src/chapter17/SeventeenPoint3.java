package chapter17;
/* Solution 0: Multiplying out the factorial, then counting the trailing 0's (by continuously dividing by 10). Problem is that n! is 
 * probably larger than maximum "int" size */

public class SeventeenPoint3{
	/* Algorithm: # of 0's is determined by # of 10's, which is determined b # of 2's and 5's. There are always enough 2's,
	 *            so we need to count the # of 5's 
	 */
	
	/* Solution 1 - Count # of 5's in each term of the factorial */
	public int factorsof5(int i){
		int count = 0;
		while(i % 5 == 0){
			count++;
			i /= 5;
		}
		return count;
	}
	
	public int countFactZeros(int num){
		if (num < 0)
			return -1;
		int count = 0;
		for (int i = 5; i <= num; i++){		//coulda done i += 5
			count += factorsof5(i);
		}
		return count;
	}
	
	/* Solution 2 - Count multiples of 5 (between 1 and n), then multiples of 25, then 125... */
	public int countFactZeros2(int num){
		if (num < 0)
			return -1;
		int count = 0;
		
		for (int i = 5; num / i > 0; i *= 5){	//code is cryptic, but it is a direct result of our simple algorithm.
			count += num / i;
		}
		return count;
	}
}
