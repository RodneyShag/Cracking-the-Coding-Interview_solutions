// github.com/RodneyShag

package _3_2_Stack_Min;

import java.util.Stack;

public class StackMin {
    // Can alternatively use ArrayDeque (it's faster)
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>(); // keeps track of minimums

    // Always push onto stack. If it's a minimum, also push it onto minStack
    void push(int x) {
        stack.push(x);
        if (min() == null || x <= min()) {
            minStack.push(x);
        }
    }

    // Pop off stack. If we popped a minimum, we gotta remove it from minStack also
    Integer pop() {
        if (stack.isEmpty()) {
            return null;
        }
        int x = stack.pop();
        if (x == minStack.peek()) {
            minStack.pop();
        }
        return x;
    }

    // minStack gives us minimum in O(1) time
    Integer min() {
        if (minStack.isEmpty()) {
            return null;
        } else {
            return minStack.peek();
        }
    }
}

// References
//
// int vs Integer comparison: https://stackoverflow.com/questions/18445158/int-vs-integer-comparison-java)
//
// In our case, we can safely use <= to compare an int to an Integer. 
// However, if we were comparing 2 Integers, we would have to use .intValue(),
// .compareTo(Object other), or .equals(Object other).
