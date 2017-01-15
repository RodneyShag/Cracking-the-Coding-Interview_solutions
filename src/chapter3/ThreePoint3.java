package chapter3;
import java.util.ArrayList;

/* Stupid implementation. I should have used an ArrayList<Stack<Integer>> */
public class ThreePoint3 {
	ArrayList<StackSpecial> stacks = new ArrayList<StackSpecial>();
	int capacity = 100;
	
	public void push(int n){
		StackSpecial last = getLastStack();
		if (last != null && last.size() != capacity)
			last.push(n);
		else{
			StackSpecial newestStack = new StackSpecial(capacity);
			newestStack.push(n);
			stacks.add(newestStack);
		}
	}
	
	public int pop(){
		StackSpecial last = getLastStack();
		if (last == null)
			return -1;	//we will have this be our error for now.
		int result = last.pop();
		if (last.size() == 0)
			stacks.remove(stacks.size() - 1);
		return result;
	}
	
	public StackSpecial getLastStack(){
		if (stacks.size() == 0)
			return null;
		else
			return stacks.get(stacks.size() - 1);
	}
}

/* Tricks utilized for "Follow-up", which is too long to code
 * 1) In an interview, I would take the route (that the book mentions) of NOT shifting when they pop from one of the middle stacks
 * 2) In the shifting solution, the book has represents each STACK as a DOUBLY-LINKED LIST. Also, the top of one stack points
 *    to the bottom of the next stack.
 */

