package chapter4;
import java.util.ArrayList;
import java.util.LinkedList;

/* Good problem */
/* Tricky Skills:
 * 1) Knowing I should return an "ArrayList<LinkedList<Node>>". 
 * 2) Knowing that, to alter the "ArrayList<LinkedList<Node>>", I should be passing it as a parameter so it can be altered.
 * 3) Know to also pass the "level" down the tree
 * 4) Making a DEEP COPY whenever we add Nodes to the list.
 */
public class FourPoint4 {
	ArrayList<LinkedList<TreeNode>> createLinkedLists(TreeNode root){				//it was tricky knowing what data structure to return.
		ArrayList<LinkedList<TreeNode>> lists = new ArrayList<LinkedList<TreeNode>>();
		createLinkedListsHelper(lists, root, 0);
		return lists;
	}
	
	void createLinkedListsHelper(ArrayList<LinkedList<TreeNode>> lists, TreeNode root, int level){	
		if (root == null)
			return;
		/* May need a new list for a new level */
		if (lists.size() == level)				//levels are visited in order, so this should work.
			lists.add(new LinkedList<TreeNode>());
		
		/* Add this Node */
		LinkedList<TreeNode> list = lists.get(level);	//get the appropriate list to add the node to.
		list.add(new TreeNode(root.data));				//DEEP COPY (This is the only step I forgot the 2nd time I coded this)
		
		/* Recursively add this nodes subtrees */
		createLinkedListsHelper(lists, root.left,  level + 1);
		createLinkedListsHelper(lists, root.right, level + 1);
		
	}
}

/* Solution 2: Iterative solution in book. I don't like it */
