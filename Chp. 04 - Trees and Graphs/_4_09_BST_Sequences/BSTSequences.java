package _4_09_BST_Sequences;

import java.util.ArrayList;
import java.util.ArrayDeque;
import common.TreeNode;

public class BSTSequences {
	public static ArrayList<ArrayDeque<Integer>> allSequences(TreeNode node) {
		ArrayList<ArrayDeque<Integer>> results = new ArrayList<>();
		
		if (node == null) {
			results.add(new ArrayDeque<Integer>()); // crucial. So the code labeled "weave lists" works properly
			return results;
		}
		
		ArrayDeque<Integer> prefix = new ArrayDeque<>();
		prefix.addLast(node.data);
		
		/* Recursive Cases */
		ArrayList<ArrayDeque<Integer>> leftSeq  = allSequences(node.left);
		ArrayList<ArrayDeque<Integer>> rightSeq = allSequences(node.right);
		
		/* Weave lists  */
		for (ArrayDeque<Integer> left : leftSeq) {
			for (ArrayDeque<Integer> right : rightSeq) {
				weaveLists(left, right, results, prefix);
			}
		}
		
		return results;
	}
	
	private static void weaveLists(ArrayDeque<Integer> list1, ArrayDeque<Integer> list2, 
			          ArrayList<ArrayDeque<Integer>> results, ArrayDeque<Integer> prefix) {
		/* Base Case */
		if (list1.isEmpty() || list2.isEmpty()) {
			ArrayDeque<Integer> result = new ArrayDeque<>(prefix);
			result.addAll(list1);
			result.addAll(list2);
			results.add(result);
			return;
		}
		
		/* Use 1st entry in list1 */
		Integer temp = list1.removeFirst();
		prefix.addLast(temp);
		weaveLists(list1, list2, results, prefix);
		prefix.removeLast();
		list1.addFirst(temp);
		
		/* Use 1st entry in list2 */
		temp = list2.removeFirst();
		prefix.addLast(temp);
		weaveLists(list1, list2, results, prefix);
		prefix.removeLast();
		list2.addFirst(temp);
	}
}
