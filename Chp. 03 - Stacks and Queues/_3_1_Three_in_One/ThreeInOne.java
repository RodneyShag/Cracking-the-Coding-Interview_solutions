// github.com/RodneyShag

package _3_1_Three_in_One;

// Use "int[] heads = {-1,-1,-1}" and simply implement arrayOffset(int stackNum), push/pop/peek

public class ThreeInOne {
    private final int numStacks = 3;
    private final int stackSize = 100;
    private int[] array = new int[stackSize * numStacks];
    private int[] heads = { -1, -1, -1 };

    public void push(int value, int stackNum) throws Exception {
        if (stackNum < 0 || stackNum >= numStacks) {
            throw new Exception("stackNum out of range");
        }
        if (heads[stackNum] >= stackSize) {
            throw new Exception("Out of space");
        }
        heads[stackNum]++;
        int offset = arrayOffset(stackNum) + heads[stackNum];
        array[offset] = value;
    }

    public int pop(int stackNum) throws Exception {
        if (heads[stackNum] == -1) {
            throw new Exception("No element to pop");
        }
        int offset = arrayOffset(stackNum) + heads[stackNum];
        heads[stackNum]--;
        return array[offset];
    }

    public int peek(int stackNum) throws Exception {
        if (heads[stackNum] == -1) {
            throw new Exception("No element to pop");
        }
        int offset = arrayOffset(stackNum) + heads[stackNum];
        return array[offset];
    }

    public boolean isEmpty(int stackNum) {
        return (heads[stackNum] == -1);
    }

    private int arrayOffset(int stackNum) {
        return stackSize * stackNum;
    }

    // Added for testing
    public void print() {
        for (int stackNum = 0; stackNum <= 2; stackNum++) {
            System.out.print("\nStack #" + stackNum + ": ");
            for (int i = arrayOffset(stackNum); i <= arrayOffset(stackNum) + heads[stackNum]; i++) {
                System.out.print(array[i] + " ");
            }
        }
    }

    // If we want variable stack sizes, these 3 things (from book's complicated code) are relevant
    // 1) If, for example, stack 1 gets too big, they shift stack 2 over (by copying over elements 1 by 1 starting from the end of the stack)
    // 2) The array is allowed to wrap around on itself (so will need to use % operator)
    // 3) They made a new class called "StackData" to keep track of a bunch of information about each stack instead of just "head"
}

//  Time Complexity: O(1) for push(), pop(), peek(), isEmpty(), arrayOffset()
// Space Complexity: O(1) for push(), pop(), peek(), isEmpty(), arrayOffset(). O(n) permanent storage needed for "array"
