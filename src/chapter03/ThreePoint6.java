package chapter03;

import java.util.Stack;

//  Time Complexity: O(n^2)
// Space Complexity: O(n)

public class ThreePoint6 {
	/* Clever Algorithm */
	public static Stack<Integer> sort(Stack<Integer> stack) {
		Stack<Integer> helperStack = new Stack<Integer>();
		while (!stack.isEmpty()) {
			Integer curr = stack.pop(); // saving the top of the stack is one of the main tricks.
			while (!helperStack.isEmpty() && curr < helperStack.peek()) {
				stack.push(helperStack.pop());
			}
			helperStack.push(curr);
		}
		return helperStack;
	}
}
