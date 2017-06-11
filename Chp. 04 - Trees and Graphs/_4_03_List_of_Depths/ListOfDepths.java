package _4_03_List_of_Depths;

import java.util.ArrayList;
import java.util.LinkedList;
import common.TreeNode;

// Tricky Skills:
// 1) Knowing I should return an "ArrayList<LinkedList<Node>>". 
// 2) Knowing that, to alter the "ArrayList<LinkedList<Node>>", I should be passing it as a parameter so it can be altered.
// 3) Know to also pass the "level" down the tree.
// 4) Remembering to create new LinkedLists in our ArrayList when necessary.
// 5) Making a DEEP COPY whenever we add Nodes to the list.

public class ListOfDepths {
	public static ArrayList<LinkedList<TreeNode>> createLists(TreeNode root) {
		ArrayList<LinkedList<TreeNode>> lists = new ArrayList<>();
		createListsHelper(root, lists, 0);
		return lists;
	}
	
	public static void createListsHelper(TreeNode node, ArrayList<LinkedList<TreeNode>> lists, int currLevel) {	
		if (node == null) {
			return;
		}
		
		/* Tricky. May need a new list for a new level */
		if (lists.size() == currLevel) { // levels are visited in order, so this should work.
			lists.add(new LinkedList<TreeNode>());
		}
		
		/* Add this Node */
		LinkedList<TreeNode> list = lists.get(currLevel); // get the appropriate list to add the node to.
		list.add(new TreeNode(node.data));			      // DEEP COPY - don't forget!
		
		/* Recursively add this nodes subtrees */
		createListsHelper(node.left, lists, currLevel + 1);
		createListsHelper(node.right, lists, currLevel + 1);
	}
}
