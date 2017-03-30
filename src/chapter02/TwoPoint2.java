package chapter02;

/* Find kth to last element of SLL
 * 
 * Solutions                                             Runtime
 * -------------------------------------------------------------
 * 1) Use list's size to return "length - k" element     O(n)
 * 2) If list size unknown, use Recursion + IntWrapper   O(n)
 */
public class TwoPoint2 {
	/* Solution 1 */
	public static Node kthToLast_1(Node n, int k) {
		if (n == null) {
			return null;
		}
		int size = ListFunctions.calculateSize(n);
		if (k <= 0 || k > size) {
			return null;
		}
		for (int i = 0; i < size - k; i++) {
			n = n.next;
		}
		return n;
	}

	/* Solution 2 */
	public static Node kthToLast_2(Node n, int k) {
		return kthToLast_2_helper(n, k, new IntWrapper());
	}
	
	public static Node kthToLast_2_helper(Node n, int k, IntWrapper iw) {
		if (n == null) {
			return null;
		} else {
			Node node = kthToLast_2_helper(n.next, k, iw);
			iw.value++;
			if (k == iw.value) {
				return n;
			} else {
				return node; // keeps returning null, until hopefully we find a match, then it keeps returning the Node that matched
			}
		}
	}
}
