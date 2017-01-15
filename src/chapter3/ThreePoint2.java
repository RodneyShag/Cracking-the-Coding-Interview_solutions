package chapter3;
import java.util.Stack;

/* My solution is superior to book's solution
 * - dealing with empty stacks is annoying
 */
public class ThreePoint2 {
	Stack<Integer> stack    = new Stack<Integer>();
	Stack<Integer> minStack = new Stack<Integer>();
	
	void push(int n){
		stack.push(n);
		if (n < min())
			minStack.push(n);
	}
	
	Integer pop(){
		if (stack.isEmpty())
			return null;
		Integer n = stack.pop();
		if (n == minStack.peek())
			minStack.pop();
		return n;
	}
	
	Integer min(){
		if (minStack.isEmpty())
			return Integer.MAX_VALUE;
		else
			return minStack.peek();
	}
}
