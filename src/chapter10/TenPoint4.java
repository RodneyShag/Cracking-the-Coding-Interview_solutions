package chapter10;
/* Tricks:
 * - Noticing 4 KB = 8 * 4 * 2^10 is greater than 32000, so a bit vector works
 * - Using BitSet instead of HashMap since we have limited memory.
 */
public class TenPoint4 {
	public static void checkDuplicates(int [] array){
		BitSet bs = new BitSet(32000);
		for (int i = 0; i < array.length; i++){
			int num = array[i];
			//book had an extra statement (num0 = ...) here that I don't think is necessary
			if (bs.get(num))
				System.out.println(num);
			else
				bs.set(num);
		}
	}
}
