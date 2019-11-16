// github.com/RodneyShag

package __Intro_Stack;

import common.ListFunctions;

public class Tester {
    public static void main(String[] args) {
        System.out.println("*** Test Stack\n");
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        System.out.println("(top of stack printed first)\n");
        System.out.print("Stack after 3 pushes: ");
        ListFunctions.printList(s.peek());
        s.pop();
        System.out.print("Stack after pop     : ");
        ListFunctions.printList(s.peek());
    }
}
