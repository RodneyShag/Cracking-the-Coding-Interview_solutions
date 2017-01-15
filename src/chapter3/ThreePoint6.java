package chapter3;
import java.util.Stack;

/* Clever Algorithm. Memorize it. Straight from book. 
 * Solving this by hand (w/o code) makes the code trivial to write.
 * O(n^2) time, O(n) Space
 */
public class ThreePoint6 {
	public static Stack<Integer> sort(Stack<Integer> stack){
		Stack<Integer> helperStack = new Stack<Integer>();
		while (!stack.isEmpty()){
			Integer curr = stack.pop();
			while(!helperStack.isEmpty() && curr < helperStack.peek()){
				stack.push(helperStack.pop());
			}
			helperStack.push(curr);
		}
		return helperStack;
	}
}