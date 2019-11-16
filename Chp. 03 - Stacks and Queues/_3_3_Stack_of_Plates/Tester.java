// github.com/RodneyShag

package _3_3_Stack_of_Plates;

public class Tester {
    public static void main(String[] args) {
        System.out.println("*** Test 3.3: Stack of Plates\n");
        StackOfPlates stack = new StackOfPlates();
        for (int i = 1; i <= 5; i++) {
            System.out.println("Pushed " + i);
            stack.push(i);
        }
        for (int i = 1; i <= 5; i++) {
            System.out.println("Popped " + stack.pop());
        }
    }
}
