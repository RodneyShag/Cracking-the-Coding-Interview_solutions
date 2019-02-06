package _3_2_Stack_Min;

public class Tester {
    public static void main(String[] args) {
        System.out.println("*** Test 3.2: Stack Min\n");
        System.out.println("Building stack: 8 4 6 3 3\n");
        StackMin myStack = new StackMin();
        myStack.push(8);
        System.out.println("(after 1st push) Min = " + myStack.min());
        myStack.push(4);
        System.out.println("(after 2nd push) Min = " + myStack.min());
        myStack.push(6);
        System.out.println("(after 3rd push) Min = " + myStack.min());
        myStack.push(3);
        System.out.println("(after 4th push) Min = " + myStack.min());
        myStack.push(3);
        System.out.println("(after 5th push) Min = " + myStack.min());
        myStack.pop();
        System.out.println("(after 1st pop) Min = " + myStack.min());
        myStack.pop();
        System.out.println("(after 2nd pop) Min = " + myStack.min());
    }
}
