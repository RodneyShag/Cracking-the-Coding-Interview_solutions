// github.com/RodneyShag

package common;

public class ListFunctions {
    public static void printList(Node head) {
        if (head == null) {
            return;
        }
        Node n = head;
        while (n != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }
        System.out.println();
    }

    public static Node deleteNode(Node head, int d) { // "d" is the node we want to delete
        if (head == null) {
            return null;
        }

        Node n = head; // start at beginning of list

        /* If data is at beginning of list */
        if (n.data == d) {
            return n.next;
        }

        /* If data is in middle or end of list */
        while (n.next != null) {
            if (n.next.data == d) {
                n.next = n.next.next;
                break;
            }
            n = n.next;
        }

        return head;
    }

    /* Returns size of linked list */
    public static int calculateSize(Node head) {
        Node n = head;
        int size = 0;
        while (n != null) {
            size++;
            n = n.next;
        }
        return size;
    }

    /* Used in 2.5 */
    public static Node insertInFront(Node head, int value) {
        Node front = new Node(value);
        front.next = head;
        return front;
    }

    //  Time Complexity: O(n)
    // Space Complexity: O(1)
    public static Node reverseListIterative(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node prev = null;
        Node curr = head;
        Node next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev; // changes direction of arrow in SLL.
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
