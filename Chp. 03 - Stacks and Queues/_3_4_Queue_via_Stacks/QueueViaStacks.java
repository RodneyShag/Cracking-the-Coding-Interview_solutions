package _3_4_Queue_via_Stacks;

import java.util.Stack;

public class QueueViaStacks<T> {
    private Stack<T> stack1 = new Stack<>();
    private Stack<T> stack2 = new Stack<>();

    public int size() {
        return stack1.size() + stack2.size();
    }

    public void enqueue(T item) {
        stack1.push(item);
    }

    public T dequeue() {
        if (size() == 0) {
            return null;
        }
        if (stack2.isEmpty()) {
            shiftStacks();
        }
        return stack2.pop();
    }

    public T peek() {
        if (size() == 0) {
            return null;
        }
        if (stack2.isEmpty()) {
            shiftStacks();
        }
        return stack2.peek();
    }

    private void shiftStacks() {
        if (stack2.isEmpty()) { // shifting items while stack2 has elements in it would mess up our queue's ordering
            while (!stack1.isEmpty()) {
                T temp = stack1.pop();
                stack2.push(temp);
            }
        }
    }
}
