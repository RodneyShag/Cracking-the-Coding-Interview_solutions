package _3_5_Sort_Stack;

import java.util.Stack;

public class Tester {
    public static void main(String[] args) {
        System.out.println("*** Test 3.6: Sort Stack\n");
        Stack<Integer> stackToSort = new Stack<>();
        stackToSort.push(3);
        stackToSort.push(7);
        stackToSort.push(2);
        stackToSort.push(6);
        stackToSort.push(1);
        System.out.println("Original stack: " + stackToSort);
        Stack<Integer> sortedStack = SortStack.sort(stackToSort);
        System.out.println("Sorted stack:   " + sortedStack);
    }
}
