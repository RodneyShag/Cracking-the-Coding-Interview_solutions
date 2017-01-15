package chapter17;
/* CLEVER TRICK ANSWER! */
public class SeventeenPoint11 {
	public static int rand7(){
		while(true){
			int num = 5 * rand5() + rand5();	//CLEVER TRICK: generates random number between 0 and 24 EVENLY DISTRIBUTED
			if (num < 21)
				return num % 7;
		}
	}
	
	/* returns an "int": 0, 1, 2, 3, 4.  NOT a float */
	private static int rand5(){
		return (int) (Math.random() * 5);
	}
	
	
	/* Part 2 - the other way to do it (shown in the book) is not necessary and can be skipped, even though I understood the code */
}
