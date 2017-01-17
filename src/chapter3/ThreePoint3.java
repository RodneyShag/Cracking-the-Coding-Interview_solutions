package chapter3;

import java.util.ArrayList;
import java.util.Stack;

public class ThreePoint3 {
	private ArrayList<Stack<Integer>> stacks = new ArrayList<Stack<Integer>>();
	private int capacity = 3;
	
	/* Implemented to work like a standard push */
	public void push (int data){
		Stack<Integer> lastStack = getLastStack();
		if (lastStack != null && lastStack.size() < capacity)
			lastStack.push(data);
		else{
			Stack<Integer> anotherStack = new Stack<>();
			anotherStack.push(data);
			stacks.add(anotherStack);
		}
	}
	
	/* Implemented to work like a standard pop */
	public Integer pop(){
		Stack<Integer> lastStack = getLastStack();
		if (lastStack == null)
			return null;
		else{
			Integer result = lastStack.pop();
			if (lastStack.isEmpty())
				stacks.remove(stacks.size()-1);
			return result;
		}
	}
	
	/* Helper function */
	public Stack<Integer> getLastStack(){
		if (stacks.isEmpty())
			return null;
		else
			return stacks.get(stacks.size()-1);
	}
}

/*  "Follow-up" Question. Skipped cuz too long to code 4 interview (according to book) and requires new implementations of push/pop.
 *   2 possible solutions:
 *      1) Don't shift when they pop from one of middle stacks (I would do this solution)
 *      2) Do shift. Harder to do but wouldn't be impossible.
 */
