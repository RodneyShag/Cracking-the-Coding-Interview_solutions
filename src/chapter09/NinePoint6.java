package chapter09;

import java.util.ArrayList;

public class NinePoint6 {

	public static ArrayList<String> generateParentheses(int count){
		char [] str = new char[count *2];
		ArrayList<String> solutions = new ArrayList<String>();
		addParenthesis(0, count, count, str, solutions);
		return solutions;
	}
	
	private static void addParenthesis(int index, int leftRem, int rightRem, char [] expression, ArrayList<String> solutions){
		if (leftRem == 0 && rightRem == 0){
			solutions.add(String.valueOf(expression)); // .valueOf converts char[] to String
			return;
		}
		if (leftRem > 0){
			expression[index] = '(';
			addParenthesis(index + 1, leftRem - 1, rightRem, expression, solutions);
		}
		if (rightRem > 0 && rightRem > leftRem){
			expression[index] = ')';
			addParenthesis(index + 1, leftRem, rightRem - 1, expression, solutions);
		}
	}
}
