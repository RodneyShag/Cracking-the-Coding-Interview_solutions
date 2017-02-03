package chapter03;

import java.util.Stack;

/* This is problem 3.5 */
/* Notice it's parameterized! */
public class MyQueue<T> {
	Stack<T> stack1 = new Stack<T>();
	Stack<T> stack2 = new Stack<T>();
	
	public int size(){
		return stack1.size() + stack2.size();
	}
	
	public void enqueue(T item){
		stack1.push(item);
	}
	
	public T dequeue(){
		if (size() == 0)
			return null;
		if (stack2.isEmpty())
			shiftStacks();
		return stack2.pop();
	}
	
	public T peek(){
		if (size() == 0)
			return null;
		if (stack2.isEmpty())
			shiftStacks();
		return stack2.peek();
	}
	
	private void shiftStacks(){
		if (stack2.isEmpty()){ // shifting items while stack2 has elements in it would mess up our queue's ordering
			while (!stack1.isEmpty()){
				T temp = stack1.pop();
				stack2.push(temp);
			}
		}
	}
}
