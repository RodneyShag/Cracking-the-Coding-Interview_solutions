package __Intro_Queue;

import common.ListFunctions;

public class Tester {
    public static void main(String[] args) {
        System.out.println("*** Test Queue\n");
        Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);
        System.out.print("Queue after 3 enqueues: ");
        ListFunctions.printList(q.peek());
        q.remove();
        System.out.print("Queue after dequeue: ");
        ListFunctions.printList(q.peek());
    }
}
