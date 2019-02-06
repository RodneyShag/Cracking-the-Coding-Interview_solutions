package _17_12_BiNode;

// Solutions                 Preference
// ------------------------------------------
// 1) In-order Traversal     Favorite
// 2) Recursive              Worth Mentioning

public class Converter {
    /* Solution 1 */
    public static BiNode head = null;
    public static BiNode tail = null;

    public static void inorderTraverse(BiNode root) {
        if (root != null) {
            inorderTraverse(root.left);
            buildList(root);
            inorderTraverse(root.right);
        }
    }

    private static void buildList(BiNode n) {
        if (head == null || tail == null) {
            head = tail = n;
            n.left = n.right = null;
        } else {
            tail.right = n;
            n.left = tail;
            tail = n;
        }
    }

	/* Solution 2 - Recursive Solution. Uses our own created NodePair data structure */
    public static NodePair convert(BiNode root) {
        if (root == null) {
            return null;
        }
        NodePair left = convert(root.left);
        NodePair right  = convert(root.right);
        join(left == null ? null : left.tail, root);
        join(root, right == null ? null : right.head);
        return new NodePair(left == null ? root : left.head, right == null ? root : right.tail);
    }

    private static void join(BiNode node1, BiNode node2) {
        if (node1 != null) {
            node1.right = node2;
        }
        if (node2 != null) {
            node2.left = node1;
        }
    }
}
