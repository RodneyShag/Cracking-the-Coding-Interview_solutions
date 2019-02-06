package _2_8_Loop_Detection;

import common.Node;

public class Tester {
    public static void main(String[] args) {
        System.out.println("*** Test 2.8: Loop Detection\n");
        Node a1 = new Node(1);
        Node a2 = new Node(2); // will be beginning of loop.
        Node a3 = new Node(3);
        Node a4 = new Node(4);
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a2; // a4 points to beginning of loop (a2).
        test(a1);
    }

    private static void test(Node head) {
        Node loopBeginning = LoopDetection.findBeginning(head);
        System.out.println("Loop Beginning Value (Should be 2): " + loopBeginning.data);
    }
}
