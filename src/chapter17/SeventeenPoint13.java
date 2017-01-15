package chapter17;

public class SeventeenPoint13 {
	/* Solution 0 - From Website. The best solution */
	static BiNode head;
	static BiNode tail;
	    
    static void inorderTraverse(BiNode root) {
        if (root == null) 
        	return;
        inorderTraverse(root.node1);
        buildList(root);
        inorderTraverse(root.node2);
    }
    
    static void buildList(BiNode n) {
        if (head == null || tail == null) {
            head = tail = n;
            n.node1 = n.node2 = null;
        }
        else {
            tail.node2 = n;
            n.node1 = tail;
            tail = n;
        }
    }
    
	/* Solution 1 - Recursive Solution. Using our own created NodePair data structure */
	public static NodePair convert(BiNode root){
		if (root == null)
			return null;
		
		NodePair left = convert(root.node1);
		NodePair right = convert(root.node2);
		join(left == null ? null : left.tail, root);
		join(root, right == null ? null : right.head);
		return new NodePair(left == null ? root : left.head, right == null ? root : right.tail);
	}
	
	/* Putting this as a function is a good idea */
	private static void join(BiNode left, BiNode right){
		if (left != null)
			left.node2 = right;
		if (right != null)
			right.node1 = left;
	}
	
	/* Solution 2 - Bad solution - Always return head of list, and use it to find tail. Not efficient */
	
	/* Solution 3 - Bad solution (cuz overly complicated) - Always return head of list, but create circular linked lists so head and tail
	 * are connected and searching for tail becomes O(1) time. */
	
	
}
