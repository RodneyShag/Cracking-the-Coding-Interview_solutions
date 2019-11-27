// github.com/RodneyShag

package _3_4_Queue_via_Stacks;

public class Tester {
    public static void main(String[] args) {
        System.out.println("*** Test 3.4: Queue via Stacks\n");
        System.out.println("elements we will be inserting: 1, 2, 3, 4, 5\n");
        QueueViaStacks<Integer> myQueue = new QueueViaStacks();
        myQueue.add(1);
        myQueue.add(2);
        myQueue.add(3);
        myQueue.add(4);
        System.out.println("1st dequeued = " + myQueue.remove());
        myQueue.add(5);
        System.out.println("2nd dequeued = " + myQueue.remove());
        System.out.println("3rd dequeued = " + myQueue.remove());
    }
}
