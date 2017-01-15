package chapter9;
import java.util.ArrayList;

public class NinePoint6 {
	/* Book's 1st solution is crappy algorithm */
	
	/* Solution 2 - mostly from book. Memorize this solution since I wouldn't be able to figure it out on my own */
	
	/* Wrapper */
	public static ArrayList<String> generateParens(int count){
		char [] str = new char[count *2];
		ArrayList<String> list = new ArrayList<String>();
		addParen(0, count, count, str, list);
		return list;
	}
	
	public static void addParen(int count, int leftRem, int rightRem, char[] str, ArrayList<String> list){
		if (leftRem < 0 || rightRem < 0 || rightRem < leftRem)
			return;	//invalid state
		if (leftRem == 0 && rightRem == 0){
			String s = String.valueOf(str);		//converts char[] to String!
			list.add(s);
		}
		else{
			if (leftRem > 0){
				str[count] = '(';
				addParen(count + 1, leftRem - 1, rightRem, str, list);
			}
			if (rightRem > 0 && rightRem > leftRem){
				str[count] = ')';
				addParen(count + 1, leftRem, rightRem - 1, str, list);
			}
		}
	}
	

}
