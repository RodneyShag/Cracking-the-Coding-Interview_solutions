package chapter03;

import java.util.Stack;

public class ThreePoint2 {
	/* Can alternatively use ArrayDeque (it's faster) */
	Stack<Integer> stack    = new Stack<>();
	Stack<Integer> minStack = new Stack<>(); // keeps track of minimums
	
	/* Always push onto stack. If it's a minimum, also push it onto minStack */
	void push(int n) {
		stack.push(n);
		if (min() == null || n <= min()) {
			minStack.push(n);
		}
	}
	
	/* Pop off stack. If we popped a minimum, we gotta remove it from minStack also */
	Integer pop() {
		if (stack.isEmpty()) {
			return null;
		}
		Integer n = stack.pop();
		if (n == minStack.peek()) {
			minStack.pop();
		}
		return n;
	}
	
	/* minStack gives us minimum in O(1) time */
	Integer min() {
		if (minStack.isEmpty()) {
			return null;
		} else {
			return minStack.peek();
		}
	}
}
